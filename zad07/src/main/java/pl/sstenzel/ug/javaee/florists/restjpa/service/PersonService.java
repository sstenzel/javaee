package pl.sstenzel.ug.javaee.florists.restjpa.service;

import pl.sstenzel.ug.javaee.florists.restjpa.domain.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonService {

    @PersistenceContext
    EntityManager em;

    public void addPerson(Person person){
        em.persist(person);
    }

    public Person getPerson(Long id) {
        return em.find(Person.class, id);
    }

    public void updatePerson(Person person){
        em.merge(person);
    }

    public List<Person> getAllPeople(){
        return em.createNamedQuery("person.getAll").getResultList();
    }

}
