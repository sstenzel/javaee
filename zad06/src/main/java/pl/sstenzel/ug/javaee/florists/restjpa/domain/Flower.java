package pl.sstenzel.ug.javaee.florists.restjpa.domain;
//import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "flower.getAll", query = "Select f from Flower f"),
        @NamedQuery(name="flower.deleteAll", query="Delete from Flower")
})
public class Flower {
    private long id;
    private String name;
//    private Date dateOfPlant;
//    private Boolean dogToxic;

    private List<Person> watermen = new ArrayList<>();

    public Flower() {
    }

        public Flower(String name) {
        super();
        this.name = name;

    }

        public Flower(long id, String name) {
        super();
        this.name = name;
        this.id = id;
    }
//
//    public Flower(String name, Date pickDate, Boolean dogToxic, double price, long amount) {
//        super();
//        this.name = name;
//        this.pickDate = pickDate;
//        this.dogToxic = dogToxic;
//        this.price = price;
//        this.amount = amount;
//    }
//    public Flower(long id, String name, Date pickDate, Boolean dogToxic, double price, long amount) {
//        this(name, pickDate, dogToxic, price, amount);
//        this.id = id;
//    }
//
//    public Flower(String name, String pickDate, String dogToxic, String price, String amount) {
//        this.name = name;
//        this.setPickDate(pickDate);
//        this.dogToxic = Boolean.parseBoolean(dogToxic);
//        this.price = Integer.parseInt(price);
//        this.amount = Integer.parseInt(amount);
//    }
//
//    public Flower(String id, String name, String pickDate, String dogToxic, String price, String amount) {
//        this(name, pickDate, dogToxic, price, amount);
//        this.setId(Long.parseLong(id));
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
//    public Date getPickDate() {
//        return pickDate;
//    }

//    public void setPickDate(Date pickDate) {
//        this.pickDate = pickDate;
//    }
//
//    public void setPickDate(String pickDate) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        this.pickDate = new Date(format.format(pickDate));
//    }
//
////    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    public Date getPickDate() {
//        return pickDate;
//    }
//
//    public Boolean getDogToxic() {
//        return dogToxic;
//    }
//    public void setDogToxic(Boolean dogToxic) {
//        this.dogToxic = dogToxic;
//    }
//    public double getPrice() {
//        return price;
//    }
//    public void setPrice(double price) {
//        this.price = price;
//    }
//    public long getAmount() { return amount; }
//    public void setAmount(long amount) { this.amount = amount; }

//    public boolean isOneMoreItem (long inBasket) {
//        if(getAmount() > inBasket){
//            return true;
//        }
//        return false;
//    }
//    public void substractAmount(long amount) {
//        this.amount -= amount;
//    }

//    @Override
//    public String toString() {
//        return "Flower name: '" + name + '\'' +
//                ", \tpick up date: " + new SimpleDateFormat("dd/MM/yy").format(pickDate.getTime()) +
//                ", \ttoxic for dogs: " + dogToxic +
//                ", \tprice: " + price +
//                ", \tamount: " + amount ;
//    }


            // EAGER - pobiera wszystko, potem mozemy sobie wybierac dowolne wartosci
            // LazyInicjalization	- ladowane wtedy gdy sa potrzebne
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Person> getWatermen() {
        return watermen;
    }

    public void setWatermen(List<Person> watermen) {
        this.watermen = watermen;
    }

    public void addWatermen (List<Person> watermen){
        // TODO ...
    }

}