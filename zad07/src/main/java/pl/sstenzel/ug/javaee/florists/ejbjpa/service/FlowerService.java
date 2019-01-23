package pl.sstenzel.ug.javaee.florists.ejbjpa.service;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.nio.channels.FileLock;
import java.util.*;

@Stateless  // tworzymy bezstanowe managery
public class FlowerService {


    @PersistenceContext     // (unitName="demoPU")
            // lepiej dodac unit nazwe w razie gdybysmy mieli kilka baz danych
            // nazwa widoczna w persistence.xml
    EntityManager entityManager; // z javax, manager do zarzadzania baza

    public Flower getFlower(Long id){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flower> c = builder.createQuery(Flower.class);
        Root<Flower> flower = c.from(Flower.class);
        flower.fetch("persons", JoinType.LEFT);
        flower.fetch("type", JoinType.LEFT);
        flower.fetch("careDescription", JoinType.LEFT);
        c.where(builder.equal(flower.get("id"), id));
        c.distinct(true);
        return entityManager.createQuery(c).getSingleResult();
    }

    public void addFlower (Flower flower){
        entityManager.persist(flower);
    }

    @SuppressWarnings("unchecked")
    public List<Flower> getAllFlowers(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flower> c = builder.createQuery(Flower.class);
        Root<Flower> root = c.from(Flower.class);
        root.fetch("persons", JoinType.LEFT);
        root.fetch("type", JoinType.LEFT);
        root.fetch("careDescription", JoinType.LEFT);
        c.distinct(true);
        return entityManager.createQuery(c).getResultList();
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
        CriteriaQuery<Person> c = builder.createQuery(Person.class);
        Root<Person> root = c.from(Person.class);
        root.fetch("persons", JoinType.LEFT);
        c.where(builder.equal(root.get("id"), id));
        c.distinct(true);
        return entityManager.createQuery(c).getResultList();
    }

    public boolean addWaterman(long flowerId, long personId) {
        Flower f = entityManager.find(Flower.class, flowerId);
        Person p = entityManager.find(Person.class, personId);
        if(f == null || p==null)
            return false;
        f.getPersons().add(p);
        entityManager.merge(f);
        return true;
    }


    public boolean removeWaterman(long flowerId, long personId) {
        Flower f = entityManager.find(Flower.class, flowerId);
        Person p = entityManager.find(Person.class, personId);
        if(f == null || p==null)
            return false;
        f.getPersons().remove(p);
        entityManager.merge(f);
        return true;
    }


    public boolean setCard(long flowerId, Card card) {
        Flower f = entityManager.find(Flower.class, flowerId);
        entityManager.persist(card);
        if(f == null || card==null)
            return false;
        f.setCareDescription(card);
        entityManager.merge(f);
        return true;
    }

//    public boolean addFertilization(long flowerId, Fertilization fertilization) {
//        Flower f = entityManager.find(Flower.class, flowerId);
//        entityManager.persist(fertilization);
//        if(f == null || fertilization==null)
//            return false;
//        f.getFertilizations().add(fertilization);
//        entityManager.merge(f);
//        return true;
//    }

    public boolean setType(long flowerId, long typeId) {
        Flower f = entityManager.find(Flower.class, flowerId);
        Type t = entityManager.find(Type.class, typeId);
        if(f == null || t==null)
            return false;
        f.setType(t);
        entityManager.merge(f);
        return true;
    }



}
