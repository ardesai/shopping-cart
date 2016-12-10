package com.acmecorp.shoppingcart.service;

import com.acmecorp.shoppingcart.model.Item;
import org.junit.*;

import java.util.*;

import static com.acmecorp.shoppingcart.model.Item.Apple;
import static com.acmecorp.shoppingcart.model.Item.Orange;

import static org.junit.Assert.*;

/**
 * Created by abhishekdesai on 10/12/2016.
 */
public class ShoppingCartServiceTest {

    private ShoppingCartService shoppingCartService;

    @Before
    public void setUp() throws Exception {
        shoppingCartService = new ShoppingCartService();
    }

    @Test
    public void testGetTotalCostWithNull() throws Exception {
        String totalCost = shoppingCartService.getTotalCost(null);
        assertEquals("£0.00", totalCost);
    }

    @Test
    public void testGetTotalCostWithNoItems() throws Exception {
        String totalCost = shoppingCartService.getTotalCost(new ArrayList<Item>());
        assertEquals("£0.00", totalCost);
    }

    @Test
    public void testGetTotalCostWithAnApple() throws Exception {
        String totalCost = shoppingCartService.getTotalCost(Arrays.asList(Apple));
        assertEquals("£0.60", totalCost);
    }

    @Test
    public void testGetTotalCostWithTwoApple() throws Exception {
        String totalCost = shoppingCartService.getTotalCost(Arrays.asList(Apple, Apple));
        assertEquals("£0.60", totalCost);
    }

    @Test
    public void testGetTotalCostWithApples() throws Exception {
        String totalCost = shoppingCartService.getTotalCost(Arrays.asList(Apple, Apple, Apple));
        assertEquals("£1.20", totalCost);
    }

    @Test
    public void testGetTotalCostWithAnOrange() throws Exception {
        String totalCost = shoppingCartService.getTotalCost(Arrays.asList(Orange));
        assertEquals("£0.25", totalCost);
    }

    @Test
    public void testGetTotalCostWithTwoOranges() throws Exception {
        String totalCost = shoppingCartService.getTotalCost(Arrays.asList(Orange, Orange));
        assertEquals("£0.50", totalCost);
    }

    @Test
    public void testGetTotalCostWithThreeOranges() throws Exception {
        String totalCost = shoppingCartService.getTotalCost(Arrays.asList(Orange, Orange, Orange));
        assertEquals("£0.50", totalCost);
    }

    @Test
    public void testGetTotalCostWithOranges() throws Exception {
        String totalCost = shoppingCartService.getTotalCost(Arrays.asList(Orange, Orange, Orange, Orange));
        assertEquals("£0.75", totalCost);
    }

    @Test
    public void testGetTotalCostWithApplesAndOranges() throws Exception {
        String totalCost = shoppingCartService.getTotalCost(Arrays.asList(Apple, Orange, Apple, Orange, Apple, Orange, Orange));
        assertEquals("£1.95", totalCost);
    }
}