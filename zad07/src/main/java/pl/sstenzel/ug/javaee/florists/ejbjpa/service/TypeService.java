package pl.sstenzel.ug.javaee.florists.ejbjpa.service;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Type;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Stateless
public class TypeService {

    @PersistenceContext
    EntityManager entityManager;
    @Inject
    FlowerService flowerService;

    public void addType(Type type){
        entityManager.persist(type);
    }

    public Type getType(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Type> c = builder.createQuery(Type.class);
        Root<Type> root = c.from(Type.class);
        c.where(builder.equal(root.get("id"), id));
        c.distinct(true);
        return entityManager.createQuery(c).getSingleResult();
    }

    public Type updateType(Type type){
        return entityManager.merge(type);
    }

    public boolean deleteType(long id){
        if (!flowerService.findByCareDescription(id).isEmpty())
            return false;
        Type type = getType(id);
        entityManager.remove(type);
        return true;
    }


    public List<Type> getAllTypes(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Type> c = builder.createQuery(Type.class);
        Root<Type> root = c.from(Type.class);
        c.distinct(true);
        return entityManager.createQuery(c).getResultList();
    }
}
