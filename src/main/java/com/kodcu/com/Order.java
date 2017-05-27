package com.kodcu.com;

/**
 * Created by altuga on 23/05/2017.
 */
public class Order {

    public String name;
    public int quantity;
    Warehouse warehouse;
    boolean isFilled;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void fill(Warehouse warehouse) {
        this.warehouse = warehouse;
        this.isFilled = this.warehouse.setQuantity(this.name, this.quantity);
    }

    public boolean isFilled() {

        return isFilled;
    }
}
