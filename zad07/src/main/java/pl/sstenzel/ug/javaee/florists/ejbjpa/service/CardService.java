package pl.sstenzel.ug.javaee.florists.ejbjpa.service;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Card;

import javax.ejb.Stateless;
import javax.inject.Inject;
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
    @Inject
    FlowerService flowerService;

    public void addCard(Card card){
        em.persist(card);
    }

    public Card getCard(long id){
        return em.find(Card.class, id);
    }

    public boolean removeCard(long id){
        if (!flowerService.findByCareDescription(id).isEmpty())
            return false;
        Card card = getCard(id);
        em.remove(card);
        return true;
    }

    public Card updateCard(Card card){
        return em.merge(card);
    }

    public List<Card> getAllCards(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Card> c = builder.createQuery(Card.class);
        Root<Card> root = c.from(Card.class);
        c.distinct(true);
        return em.createQuery(c).getResultList();
    }
}
