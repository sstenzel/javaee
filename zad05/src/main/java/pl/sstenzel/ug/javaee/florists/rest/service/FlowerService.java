package pl.sstenzel.ug.javaee.florists.rest.service;

import pl.sstenzel.ug.javaee.florists.rest.domain.Flower;


import javax.ejb.Singleton;
import java.util.*;

@Singleton
public class FlowerService {

    private Map<Long,Flower> flowers = new HashMap<>();
    private long id = 0;

    public void add(Flower flower) {
        flower.setId(++id);
        flowers.put(id, flower);
    }

    public Flower update(Flower flower) {
        if(flowers.containsKey(flower.getId()))
            return flowers.replace(flower.getId(), flower);
        return null;
    }

    public boolean delete(long id){
        if(flowers.containsKey(id)) {
            flowers.remove(id);
            return true;
        }
        return false;
    }

    public Flower get(long id) {
        if(flowers.containsKey(id))
            return flowers.get(id);
        return null;
    }

    public Collection<Flower> getAll(){
        return flowers.values();
    }

    public void deleteAll(){
        flowers.clear();
    }
}
