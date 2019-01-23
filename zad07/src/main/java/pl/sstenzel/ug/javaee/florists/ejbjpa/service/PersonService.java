package pl.sstenzel.ug.javaee.florists.ejbjpa.service;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class PersonService {

    @PersistenceContext
    EntityManager entityManager;

    public void addPerson(Person person){
        entityManager.persist(person);
    }

    public Person getPerson(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> c = builder.createQuery(Person.class);
        Root<Person> root = c.from(Person.class);
        c.where(builder.equal(root.get("id"), id));
        c.distinct(true);
        return entityManager.createQuery(c).getSingleResult();
    }

    public void updatePerson(Person person){
        entityManager.merge(person);
    }

    public List<Person> getAllPeople(){
         CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> c = builder.createQuery(Person.class);
        Root<Person> root = c.from(Person.class);
//        c.distinct(true);
        return entityManager.createQuery(c).getResultList();
    }

}
