package pl.sstenzel.ug.javaee.florists.ejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonView;
import pl.sstenzel.ug.javaee.florists.ejbjpa.JSONView.View;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "person.findByFlowers",
                query = "SELECT p, count(f) FROM Person p JOIN p.flowers f GROUP BY p.id HAVING COUNT(f) > :amount ORDER BY count(f) desc "),
        @NamedQuery(name = "person.findByToxicFlowers",
                query = "SELECT p, count(f) FROM Person p JOIN p.flowers f WHERE f.dogToxic = :dogToxic GROUP BY p.id HAVING COUNT(f) > :amount  ORDER BY count(f) desc ")
})
public class Person {

    @JsonView({View.Person.class,View.FlowerRealtions.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonView({View.Person.class,View.FlowerRealtions.class})
    private String name;

    @JsonView({View.Person.class,View.FlowerRealtions.class})
    private String surname;

    @JsonView(View.PersonRelations.class)
    @ManyToMany(mappedBy = "persons",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Flower> flowers = new ArrayList<>();


    public Person() {}

    public Person(String name, String surname) {
        super();
        this.name = name;
        this.surname = surname;
    }


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

    public List<Flower> getFlowers() {
        return flowers;
    }
    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }
}
