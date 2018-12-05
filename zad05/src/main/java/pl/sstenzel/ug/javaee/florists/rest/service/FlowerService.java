package pl.sstenzel.ug.javaee.florists.rest.service;

import pl.sstenzel.ug.javaee.florists.rest.domain.Flower;


import javax.ejb.Singleton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
public class FlowerService {
    
    private List<Flower> flowers = Collections.synchronizedList(new ArrayList<>());

    public void add(Flower flower) {
        flowers.add(flower);
    }

    public Flower update(Flower flower) {
        for (int i = 0; i < flowers.size(); i++) {
            if(flowers.get(i).getId() == flower.getId()) {
                flowers.set(i, flower);
                return flower;
            }
        }
        return null;
    }

    public void delete(long id){
        for(Flower flower: flowers) {
            if(flower.getId() == id) {
                flowers.remove(flower);
            }
        }
    }

    public Flower get(long id) {
        for(Flower flower: flowers) {
            if(flower.getId() == id) {
                return flower;
            }
        }
        return null;
    }

    public List<Flower> getAll(){
        return flowers;
    }

    public void deleteAll(){
        flowers.clear();
    }
}
