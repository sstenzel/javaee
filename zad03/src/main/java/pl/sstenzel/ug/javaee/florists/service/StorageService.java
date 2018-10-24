package pl.sstenzel.ug.javaee.florists.service;

import pl.sstenzel.ug.javaee.florists.domain.Flower;

import java.util.Map;
import java.util.TreeMap;

public class StorageService {

        private Map<Long, Flower> assortment = new TreeMap<>();


        public Map<Long, Flower> getAssortment() {
            return assortment;
        }

        public void setAssortment(Map<Long, Flower> assortment) {
            this.assortment = assortment;
        }

        public void add (Flower flower){
            this.assortment.put(flower.getId(), flower);
        }

        public Flower get (long id){
            return this.assortment.get(id);
        }

        public void delete (long id){
            this.assortment.remove(id);
        }

}
