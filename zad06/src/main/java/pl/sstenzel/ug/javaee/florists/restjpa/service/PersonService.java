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

    public void add(Person person){
        em.persist(person);
    }

//    public List<Person> getAll(){
//    }

}
