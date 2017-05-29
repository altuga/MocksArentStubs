package com.kodcu.com;


public class Siparis {

    public String name;
    public int quantity;
    Depo warehouse;
    boolean isFilled;

    public Siparis(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void fill(Depo warehouse) {
        this.warehouse = warehouse;
        this.isFilled = this.warehouse.setQuantity(this.name, this.quantity);
    }

    public boolean isFilled() {

        return isFilled;
    }
}
