package pl.sstenzel.ug.javaee.florists.ejbjpa.service;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Card;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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

    public List<Card> getAllCards(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Card> c = builder.createQuery(Card.class);
        Root<Card> root = c.from(Card.class);
        c.distinct(true);
        return em.createQuery(c).getResultList();
    }
}
