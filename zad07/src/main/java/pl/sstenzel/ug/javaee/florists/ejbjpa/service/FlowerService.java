package pl.sstenzel.ug.javaee.florists.ejbjpa.service;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.*;
import java.sql.Date;

@Stateless
public class FlowerService {


    @PersistenceContext
    EntityManager entityManager;

    public Flower getFlower(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flower> query = builder.createQuery(Flower.class);
        Root<Flower> flower = query.from(Flower.class);
        flower.fetch("persons", JoinType.LEFT);
        flower.fetch("type", JoinType.LEFT);
        flower.fetch("careDescription", JoinType.LEFT);
        query.where(builder.equal(flower.get("id"), id));
        query.distinct(true);
        List<Flower> result = entityManager.createQuery(query).getResultList();
        if (!result.isEmpty())
            return result.get(0);
        return null;
    }

    public void addFlower (Flower flower){
        entityManager.persist(flower);
    }

    @SuppressWarnings("unchecked")
    public List<Flower> getAllFlowers(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flower> query = builder.createQuery(Flower.class);
        Root<Flower> flower = query.from(Flower.class);
        flower.fetch("persons", JoinType.LEFT);
        flower.fetch("type", JoinType.LEFT);
        flower.fetch("careDescription", JoinType.LEFT);
        query.distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    public Flower updateFlower(Flower flower) {
        return entityManager.merge(flower);
    }


    public void deleteAllFlowers() {
        entityManager.createNamedQuery("flower.deleteAll").executeUpdate();
    }


    public void deleteFlower(long id){
        Flower flower = getFlower(id);
        entityManager.remove(flower);
    }


    public List<Person> getFlowerPersons(long id){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = builder.createQuery(Person.class);
        Root<Person> flower = query.from(Person.class);
        flower.fetch("persons", JoinType.LEFT);
        query.where(builder.equal(flower.get("id"), id));
        query.distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    public boolean addWaterman(long flowerId, Person person) {
        Flower flower = entityManager.find(Flower.class, flowerId);
        entityManager.persist(person);
        if(flower == null)
            return false;
        flower.getPersons().add(person);
        entityManager.merge(flower);
        return true;
    }


    public boolean removeWaterman(long flowerId, long personId) {
        Flower flower = entityManager.find(Flower.class, flowerId);
        Person person = entityManager.find(Person.class, personId);
        if(flower == null || person==null)
            return false;
        flower.getPersons().remove(person);
        entityManager.merge(flower);
        return true;
    }


    public boolean setCard(long flowerId, Card card) {
        Flower flower = entityManager.find(Flower.class, flowerId);
        entityManager.persist(card);
        if(flower == null || card==null)
            return false;
        flower.setCareDescription(card);
        entityManager.merge(flower);
        return true;
    }

    public boolean setType(long flowerId, long typeId) {
        Flower flower = entityManager.find(Flower.class, flowerId);
        Type t = entityManager.find(Type.class, typeId);
        if(flower == null || t==null)
            return false;
        flower.setType(t);
        entityManager.merge(flower);
        return true;
    }

    public List<Flower> findFlowersByName(String name){
        Query query
                = entityManager.createNamedQuery("flower.byName");
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Flower> findFlowersByType(String type){
        Query query
                = entityManager.createNamedQuery("flower.byType");
        query.setParameter("type", type);
        return query.getResultList();
    }

    public List<Flower> findFlowersByDateBetween (Date from, Date to){
        Query query
                = entityManager.createNamedQuery("flower.findByDate");
        query.setParameter("dateFrom", from);
        query.setParameter("dateTo", to);
        return query.getResultList();
    }

    public List<Flower> findByCareDescription(String name){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flower> query = builder.createQuery(Flower.class);
        Root<Flower> flower = query.from(Flower.class);

        flower.fetch("persons", JoinType.LEFT);
        flower.fetch("type", JoinType.LEFT);
        flower.fetch("careDescription", JoinType.LEFT);
        query.where(
            builder.like(
                builder.lower(
                    flower.get("careDescription").
                        get("description")),
                "%"+name.toLowerCase()+"%")
        );
        query.distinct(true);

        return entityManager.createQuery(query).getResultList();
    }

    public List<Flower> findByCareDescription (long id){
        Query query
                = entityManager.createNamedQuery("flower.byCareDescriptionId");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Flower> findByType (long id){
        Query query
                = entityManager.createNamedQuery("flower.byTypeId");
        query.setParameter("id", id);
        return query.getResultList();
    }

}
