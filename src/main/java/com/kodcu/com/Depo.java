package com.kodcu.com;


public interface Depo {

    void add(String name, int quantity);

    int getInventory(String name);

    boolean setQuantity(String name, int newQuantity);
}
