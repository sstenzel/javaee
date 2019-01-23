package pl.sstenzel.ug.javaee.florists.ejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import pl.sstenzel.ug.javaee.florists.ejbjpa.view.View;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
public class Person {

    @JsonView({View.Person.class,View.FlowerRealtions.class})
    private long id;
    @JsonView({View.Person.class,View.FlowerRealtions.class})
    private String name;
    @JsonView({View.Person.class,View.FlowerRealtions.class})
    private String surname;

    @JsonView(View.PersonRelations.class)
    private List<Flower> flowers = new ArrayList<>();

    public Person() {}

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public void addFlower(Flower flower) {this.flowers.add(flower);}

    @ManyToMany(mappedBy = "persons",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }
}
