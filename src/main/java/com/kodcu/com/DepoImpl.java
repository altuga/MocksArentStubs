package com.kodcu.com;

import java.util.HashMap;
import java.util.Map;


public class DepoImpl implements Depo {


    Map<String, Integer> area = new HashMap<String, Integer>();

    public void add(String name, int quantity) {

        area.put(name, quantity);

    }

    public int getInventory(String name) {
        return area.get(name);
    }

    public boolean setQuantity(String name, int newQuantity) {

        int nameQuantity = area.get(name);
        int newStatusOfQuantity = nameQuantity - newQuantity;

        if (newStatusOfQuantity >= 0 ) {
            area.put(name, newStatusOfQuantity); // if we have capacity then change it. If not then do not touch
            return true;
        }
        return false;

    }
}
