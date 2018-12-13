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

    public Flower getPerson(Long id){
        return flowerService.find(Flower.class, id);
    }

    public void addPerson(Flower flower){
        flowerService.persist(flower);
    }

}
