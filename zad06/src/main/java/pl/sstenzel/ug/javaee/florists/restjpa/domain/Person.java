package pl.sstenzel.ug.javaee.florists.restjpa.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
public class Person {
    private long id;
    private String name;
    private String surname;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Flower> getFlowers() {
        return flowers;
    }
    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }
}
