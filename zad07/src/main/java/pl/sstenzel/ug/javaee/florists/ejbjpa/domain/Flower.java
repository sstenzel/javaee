package pl.sstenzel.ug.javaee.florists.ejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({                 //TODO
        @NamedQuery(name = "flower.getAll", query = "Select f from Flower f"),
//                query = "Select f from Flower f join f.watermen w where w in (:watermen)"),
//                query = "Select f from Flower f join Waterman w where w.watermen.id = w.id"),
        @NamedQuery(name="flower.deleteAll", query="Delete from Flower")
})
public class Flower {
    private long id;
    private String name;
//    private Date dateOfPlant;
//    private Boolean dogToxic;

    @ManyToMany(mappedBy="flower", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Column(name = "watermen")
    private List<Person> watermen = new ArrayList<Person>();

    @OneToOne(mappedBy="flower", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Card careDescription;

    @ManyToMany(mappedBy="flower", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Fertilization> fertilizations = new ArrayList<>();

    public Flower() {
    }

    public Flower(String name) {
        super();
        this.name = name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }


    public void addWaterman (Person waterman){
        this.watermen.add(waterman);
    }

    public  void addFertilization(Fertilization fert){
        this.fertilizations.add(fert);
    }

    public void addCareDescription(Card card){
        this.careDescription = card;
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




}