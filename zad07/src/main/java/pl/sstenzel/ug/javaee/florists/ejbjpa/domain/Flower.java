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
@NamedQueries({
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

    @JsonView(View.FlowerRealtions.class)
    private Type type;

//    @JsonView(View.FlowerRealtions.class)
//    private List<Fertilization> fertilizations = new ArrayList<>();


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

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    public List<Fertilization> getFertilizations() {
//        return fertilizations;
//    }
//    public void setFertilizations(List<Fertilization> fertilizations) {
//        this.fertilizations = fertilizations;
//    }

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Card getCareDescription() {
        return careDescription;
    }

    public void setCareDescription(Card careDescription) {
        this.careDescription = careDescription;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}