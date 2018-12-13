package pl.sstenzel.ug.javaee.florists.restjpa.service;

import pl.sstenzel.ug.javaee.florists.restjpa.domain.Flower;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class FlowerService {


    @PersistenceContext
    EntityManager flowerService;

    public Flower get(Long id){
        return flowerService.find(Flower.class, id);
    }

    public void add(Flower flower){
        flowerService.persist(flower);
    }

    @SuppressWarnings("unchecked")
    public List<Flower> getAllPersons(){
        return flowerService.createNamedQuery("flower.getAll").getResultList();
    }

}
