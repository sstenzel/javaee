package pl.sstenzel.ug.javaee.florists.ejbjpa.service;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Fertilization;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FertilizationService {

    @PersistenceContext
    EntityManager em;

    public void addFertilization(Fertilization fertilization)
    {
        em.persist(fertilization);
    }

    public Fertilization getFertilization(long id)
    {
        return em.find(Fertilization.class, id);
    }

    public void removeFertilization(long id){
        Fertilization fertilization = em.find(Fertilization.class, id);
        em.remove(fertilization);
    }
}
