package com.kodcu.com;

import org.jmock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by altuga on 24/05/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class OrderInteractionTesterMockito  {
    private static String TALISKER = "Talisker";

    @org.mockito.Mock
    Warehouse warehouseMock;

    @Test
    public void testFillingRemovesInventoryIfInStock() {
        //setup - data
        Order order = new Order(TALISKER, 50);
        when(warehouseMock.setQuantity(TALISKER, 50)).thenReturn(true);

        order.fill(warehouseMock);
        assertTrue(order.isFilled());
        assertEquals(0, warehouseMock.getInventory(TALISKER));


    }

    @Test
    public void testFillingDoesNotRemoveIfNotEnoughInStock() {
        //setup - data
        Order order = new Order(TALISKER, 51);

        when(warehouseMock.setQuantity(TALISKER, 50)).thenReturn(true);
        when(warehouseMock.getInventory(TALISKER)).thenReturn(50);

        order.fill(warehouseMock); // SUT - System Under Test
        assertFalse(order.isFilled());
        assertEquals(50, warehouseMock.getInventory(TALISKER));
        verify(warehouseMock).getInventory(TALISKER);
    }
}
