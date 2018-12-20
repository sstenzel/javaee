package pl.sstenzel.ug.javaee.florists.ejbjpa.service;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Card;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CardService {

    @PersistenceContext
    EntityManager em;

    public void addCard(Card card){
        em.persist(card);
    }

    public Card getCard(long id){
        return em.find(Card.class, id);
    }

    public void removeCard(long id){
        Card card = em.find(Card.class, id);
        em.remove(card);
    }
}
