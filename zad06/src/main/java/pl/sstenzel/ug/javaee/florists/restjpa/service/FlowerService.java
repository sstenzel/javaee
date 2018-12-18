package pl.sstenzel.ug.javaee.florists.restjpa.service;

import pl.sstenzel.ug.javaee.florists.restjpa.domain.Flower;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless  // tworzymy bezstanowe managery
public class FlowerService {


    @PersistenceContext     // (unitName="demoPU")
            // lepiej dodac unit nazwe w razie gdybysmy mieli kilka baz danych
            // nazwa widoczna w persistence.xml
    EntityManager entityManager; // z javax, manager do zarzadzania baza

    public Flower getFlower(Long id){

        return entityManager.find(Flower.class, id);
    }

    public void addFlower (Flower flower){
        entityManager.persist(flower);

        // tuatj mozna zmienic po persist wartosci flowera
        // bo cala ta funkcja jest transakcja
        // (albo do flusha)
        // encja podlaczona do contekstu i sledzi jej zmiany

        // odlaczanie od kontekstu: entityManager.detach(flower);
        // em.merge(flower);    - nanoszenie zmian
        //                      - update + podlaczenie do kontekstu
    }

    @SuppressWarnings("unchecked")
    public List<Flower> getAllFlowers(){

        return entityManager.createNamedQuery("flower.getAll").getResultList();
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

}
