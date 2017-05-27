package com.kodcu.com;

/**
 * Created by altuga on 23/05/2017.
 */
public interface Warehouse {

    void add(String name, int quantity);

    int getInventory(String name);

    boolean setQuantity(String name, int newQuantity);
}
