package pl.sstenzel.ug.javaee.florists.service;

import pl.sstenzel.ug.javaee.florists.domain.Flower;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StorageService {

    private Map<Long, Flower> assortment;
    private long availableId;

    public StorageService (){
        this.assortment = new HashMap();
        this.availableId = 1;
        fill();
    }

    private void fill(){
        add(new Flower(getAvailableId(), "Fiolek", new Date(2018,10,12),false, 5, 5));
        add(new Flower(getAvailableId(), "Gozdzik", new Date(2018,11,11),false, 11, 2));
    }

    public Collection<Flower> getAssortment() {
        return assortment.values();
    }

    public void setAssortment(Map<Long, Flower> assortment) {
        this.assortment = assortment;
    }

    public void add (Flower flower){
        this.assortment.put(flower.getId(), flower);
    }

    public void add (String rName, String rPickDate, String rDogToxic, String rPrice, String rAmount) {
        String name = rName;
        Boolean dogToxic = Boolean.parseBoolean(rDogToxic);
        double price;
        long amount;
        Date pickDate = new Date();

        try {
           price = Double.parseDouble(rPrice);
        } catch (NumberFormatException e) {
            price = 0.0;
        }

        try {
            amount = Long.parseLong(rAmount);
        } catch (NumberFormatException e) {
            amount = 0;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try{
            pickDate = format.parse(rPickDate);
        } catch (ParseException e) {}

        add(new Flower(getAvailableId(), name, pickDate, dogToxic, price, amount));
    }

    public Flower get (long id){
        return this.assortment.get(id);
    }

    public void delete (long id){
        if(this.assortment.containsKey(id)) {
            this.assortment.remove(id);
        }
    }


    public long getAvailableId() {
        return availableId++;
    }



}
