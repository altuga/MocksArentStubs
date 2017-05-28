package com.kodcu.com;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class OrderStateTester {
    private static String ISTANBUL = "Istanbul";
    private static String ERZURUM = "Erzurum";
    private Depo depo = new DepoImpl();

    @Before
    public void setUp() throws Exception {
        depo.add(ISTANBUL, 50);
        depo.add(ERZURUM, 25);
    }

    @Test
    public void testOrderIsFilledIfEnoughInWarehouse() {
        Siparis order = new Siparis(ISTANBUL, 50);
        order.fill(depo);
        Assert.assertTrue(order.isFilled());
        Assert.assertEquals(0, depo.getInventory(ISTANBUL));
    }

    @Test
    public void testOrderDoesNotRemoveIfNotEnough() {
        Siparis order = new Siparis(ISTANBUL, 51);
        order.fill(depo);
        Assert.assertFalse(order.isFilled());
        Assert.assertEquals(50, depo.getInventory(ISTANBUL));
    }
}

