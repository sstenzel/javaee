package pl.sstenzel.ug.javaee.florists.ejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({                 //TODO
        @NamedQuery(name = "flower.getAll",
                query = "Select f from Flower f"),
//                query = "Select f from Flower f joinf.watermen w where w in (:watermen)"),
//                query = "Select f from Flower f join Waterman w where w.watermen.id = w.id"),
        @NamedQuery(name="flower.deleteAll", query="Delete from Flower")
})
public class Flower {
    private long id;
    private String name;
    private Date dateOfPlant;
    private Boolean dogToxic;

    @ManyToMany(mappedBy="flower", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Column(name = "watermen")
    private List<Person> watermen = new ArrayList<Person>();

    @OneToOne(mappedBy="flower", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Card careDescription;

//    @ManyToMany(mappedBy="flower", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Fertilization> fertilizations = new ArrayList<>();


    // many to one -  fetch type - eager

    public Flower() {
    }

    public Flower(String name) {
        super();
        this.name = name;
    }

    public Flower(String name, Date dateOfPlant) {
        super();
        this.name = name;
        this.dateOfPlant = dateOfPlant;
    }

    public Flower(String name, Date dateOfPlant, Boolean dogToxic) {
        super();
        this.name = name;
        this.dateOfPlant = dateOfPlant;
        this.dogToxic = dogToxic;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }


    public void addWaterman (Person waterman){
        this.watermen.add(waterman);
    }

//    public  void addFertilization(Fertilization fert){
//        this.fertilizations.add(fert);
//    }

    public void addCareDescription(Card card){
        this.careDescription = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getDateOfPlant() {
        return dateOfPlant;
    }
    public void setDateOfPlant(Date dateOfPlant) {
        this.dateOfPlant = dateOfPlant;
    }

    public Boolean getDogToxic() {
        return dogToxic;
    }

    public void setDogToxic(Boolean dogToxic) {
        this.dogToxic = dogToxic;
    }

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