package pl.sstenzel.ug.javaee.florists.ejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import pl.sstenzel.ug.javaee.florists.ejbjpa.view.View;

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
//        query = "SELECT l FROM Laptop l LEFT JOIN FETCH l.manufacturer m LEFT JOIN FETCH l.owners")
////                query = "Select f from Flower f joinf.watermen w where w in (:watermen)"),
////                query = "Select f from Flower f join Waterman w where w.watermen.id = w.id"),
        @NamedQuery(name="flower.deleteAll", query="Delete from Flower")
})
public class Flower {

    @JsonView(View.Flower.class)
    private long id;
    @JsonView(View.Flower.class)
    private String name;
    @JsonView(View.Flower.class)
    private Date dateOfPlant;
    @JsonView(View.Flower.class)
    private Boolean dogToxic;

    @JsonView({View.FlowerRealtions.class, View.FlowerWatermen.class})
    private List<Person> persons = new ArrayList<Person>();
    @JsonView(View.FlowerRealtions.class)
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Card getCareDescription() {
        return careDescription;
    }

    public void setCareDescription(Card careDescription) {
        this.careDescription = careDescription;
    }
}