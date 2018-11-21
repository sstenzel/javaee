package pl.sstenzel.ug.javaee.florists.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasketService {

    HashMap<Long, Long> basket = new HashMap();

    public BasketService () {
    }

    public Set<Map.Entry<Long,Long>> getItems() {
        return basket.entrySet();
    }

    public void add (long id) {
        if (basket.containsKey(id))
            basket.put(id, basket.get(id)+1);
        else
            basket.put(id, (long)1);
    }

    public void remove( long id){
        if (basket.containsKey(id)) {
            if (basket.get(id) > 1)
                basket.put(id, basket.get(id) - 1);
            else
                basket.remove(id);
        }
    }

    public long getAmount (long id) {
        if (basket.containsKey(id))
            return basket.get(id);
        return 0;
    }

}
