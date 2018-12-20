package pl.sstenzel.ug.javaee.florists.ejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
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

    @JsonManagedReference
    private List<Person> watermen = new ArrayList<>();

    @JsonManagedReference
    private Card careDescription;
//
//    @JsonManagedReference
//    private List<Fertilization> fertilizations = new ArrayList<>();

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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy="parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @Fetch(value = FetchMode.SUBSELECT)
    public List<Person> getWatermen() {
        return watermen;
    }
    public void setWatermen(List<Person> watermen) {
        this.watermen = watermen;
    }
    public void addWaterman (Person waterman){
        this.watermen.add(waterman);
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Card getCareDescription() {
        return careDescription;
    }
    public void setCareDescription(Card careDescription) {
        this.careDescription = careDescription;
    }

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    public List<Fertilization> getFertilizations() {
//        return fertilizations;
//    }
//    public void setFertilizations(List<Fertilization> fertilizations) {
//        this.fertilizations = fertilizations;
//    }
//    public  void addFertilization(Fertilization fert){
//        this.fertilizations.add(fert);
//    }


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