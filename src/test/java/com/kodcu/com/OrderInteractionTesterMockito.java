package com.kodcu.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;




@RunWith(MockitoJUnitRunner.class)
public class OrderInteractionTesterMockito  {
    private static String ISTANBUL = "Istanbul";

    @org.mockito.Mock
    Depo taklitDepo;

    @Test
    public void testFillingRemovesInventoryIfInStock() {
        //setup - data
        Siparis order = new Siparis(ISTANBUL, 50);
        when(taklitDepo.setQuantity(ISTANBUL, 50)).thenReturn(true);

        order.fill(taklitDepo);
        assertTrue(order.isFilled());
        assertEquals(0, taklitDepo.getInventory(ISTANBUL));


    }

    @Test
    public void testFillingDoesNotRemoveIfNotEnoughInStock() {
        //setup - data
        Siparis order = new Siparis(ISTANBUL, 51);

        when(taklitDepo.setQuantity(ISTANBUL, 50)).thenReturn(true);
        when(taklitDepo.getInventory(ISTANBUL)).thenReturn(50);

        order.fill(taklitDepo); // SUT - System Under Test
        assertFalse(order.isFilled());
        assertEquals(50, taklitDepo.getInventory(ISTANBUL));
        verify(taklitDepo).getInventory(ISTANBUL);
    }
}
