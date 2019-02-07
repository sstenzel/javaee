package pl.sstenzel.ug.javaee.florists.ejbjpa.service;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class PersonService {

    @PersistenceContext
    EntityManager entityManager;

    public Person getPerson(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = builder.createQuery(Person.class);
        Root<Person> person = query.from(Person.class);
        person.fetch("flowers");
        query.where(builder.equal(person.get("id"), id));
        query.distinct(true);
        List<Person> result = entityManager.createQuery(query).getResultList();
        if (!result.isEmpty())
            return result.get(0);
        return null;
    }

    public void updatePerson(Person person){
        entityManager.merge(person);
    }

    public List<Person> getAllPeople(){
         CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = builder.createQuery(Person.class);
        Root<Person> person = query.from(Person.class);
        person.fetch("flowers");
        query.distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Person> findByFlowersAmount(long amount){
        Query query
                = entityManager.createNamedQuery("person.findByFlowers");
        query.setParameter("amount", amount);
        return query.getResultList();
    }
    public List<Person> findByToxicFlowers(boolean dogToxic, long amount){
        Query query
                = entityManager.createNamedQuery("person.findByToxicFlowers");
        query.setParameter("dogToxic", dogToxic);
        query.setParameter("amount", amount);
        return query.getResultList();
    }
}
