package pl.sstenzel.ug.javaee.florists.service;

import pl.sstenzel.ug.javaee.florists.domain.Drawer;
import pl.sstenzel.ug.javaee.florists.domain.Drawer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopService {

    private List<String> brand = new ArrayList<String>();
    private Map<Long, Drawer> orders = new HashMap<>();
    private long idIncremet;

    public ShopService() {
        brand.add("Super-meble");
        brand.add("IKEA super drawer");
        brand.add("Henius-meble");
        idIncremet = 1;
    }

    public Map<Long, Drawer> getOrders() {
        return orders;
    }

    public void setOrders(Map<Long, Drawer> orders) {
        this.orders = orders;
    }

    public long addOrder(Drawer drawer) {

        if(drawer.getId() > 0)
            return drawer.getId();
        drawer.setId(idIncremet);
        this.orders.put(idIncremet, drawer);
        return idIncremet++;

    }

    public Boolean removeOrder (long id){
        if(orders.get(id) != null) {
            orders.remove(id);
            return true;
        }
        return false;
    }

    public Drawer getOrder (long id){
        return orders.get(id);
    }


    public List<String> getBrand() {
        return brand;
    }

    public void setBrand(List<String> brand) {
        this.brand = brand;
    }
}
