package pl.sstenzel.ug.javaee.florists.ejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import pl.sstenzel.ug.javaee.florists.ejbjpa.JSONView.View;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "flower.findByDate",
                query = "SELECT f FROM Flower f WHERE f.dateOfPlant BETWEEN :dateFrom AND :dateTo"),
        @NamedQuery(name = "flower.byName",
                query = "SELECT f FROM Flower f WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :name, '%'))"),
        @NamedQuery(name = "flower.deleteAll", query = "DELETE FROM Flower"),
        @NamedQuery(name = "flower.byType",
                query = "SELECT f FROM Flower f JOIN f.type t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :type, '%'))"),
        @NamedQuery(name = "flower.byCareDescriptionId",
                query = "SELECT f FROM Flower f WHERE f.careDescription.id = :id"),
        @NamedQuery(name = "flower.byTypeId",
                query = "SELECT f FROM Flower f WHERE f.type.id = :id")
})


public class Flower {

    @JsonView({View.Flower.class, View.PersonRelations.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonView({View.Flower.class, View.PersonRelations.class})
    private String name;

    @JsonView({View.Flower.class, View.PersonRelations.class})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfPlant;

    @JsonView({View.Flower.class, View.PersonRelations.class})
    private Boolean dogToxic;

    @JsonView({View.FlowerRealtions.class, View.FlowerWatermen.class})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Person> persons = new ArrayList<Person>();

    @JsonView(View.FlowerRealtions.class)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Card careDescription;

    @JsonView(View.FlowerRealtions.class)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Type type;


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


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

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

    public Card getCareDescription() {
        return careDescription;
    }
    public void setCareDescription(Card careDescription) {
        this.careDescription = careDescription;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
}