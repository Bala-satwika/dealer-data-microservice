package com.tvsmotor.dealerdata.service;

import com.tvsmotor.dealerdata.Model.Item;
import com.tvsmotor.dealerdata.Model.Order;
import com.tvsmotor.dealerdata.Repository.OrderRepository;
import com.tvsmotor.dealerdata.Service.OrderService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order1;
    private Order order2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create mock Item objects
        Item item1 = new Item("Item1", 2, "delivered");
        Item item2 = new Item("Item2", 1, "pending");
        
        // Initialize mock orders
        order1 = new Order("O001", "D001", Arrays.asList(item1, item2), "2024-10-18");
        order2 = new Order("O002", "D002", Arrays.asList(item2), "2024-10-19");
    }

    @Test
    public void testGetOrdersByDealerId_SingleOrder() {
        // Mock repository behavior for dealerId "D001"
        when(orderRepository.findByDealerId("D001")).thenReturn(Arrays.asList(order1));

        // Call the service method
        List<Order> orders = orderService.getOrdersByDealerId("D001");

        // Verify the result
        assertNotNull(orders);
        assertEquals(1, orders.size());
        assertEquals("O001", orders.get(0).getOrderId());

        // Verify the interaction with the repository
        verify(orderRepository, times(1)).findByDealerId("D001");
    }

    @Test
    public void testGetOrdersByDealerId_MultipleOrders() {
        // Mock repository behavior for dealerId "D002"
        when(orderRepository.findByDealerId("D002")).thenReturn(Arrays.asList(order2));

        // Call the service method
        List<Order> orders = orderService.getOrdersByDealerId("D002");

        // Verify the result
        assertNotNull(orders);
        assertEquals(1, orders.size());
        assertEquals("O002", orders.get(0).getOrderId());

        // Verify interaction with repository
        verify(orderRepository, times(1)).findByDealerId("D002");
    }

    @Test
    public void testGetOrdersByDealerId_NoOrders() {
        // Mock repository behavior for dealerId with no orders
        when(orderRepository.findByDealerId("D003")).thenReturn(Arrays.asList());

        // Call the service method
        List<Order> orders = orderService.getOrdersByDealerId("D003");

        // Verify the result
        assertNotNull(orders);
        assertTrue(orders.isEmpty());

        // Verify interaction with repository
        verify(orderRepository, times(1)).findByDealerId("D003");
    }


    @Test
    public void testGetOrdersByDealerId_NullDealerId() {
        // Call the service method with null dealerId
        List<Order> orders = orderService.getOrdersByDealerId(null);

        // Verify the result
        assertNotNull(orders);
        assertTrue(orders.isEmpty());

        // Verify interaction with repository is not called
        verify(orderRepository, times(0)).findByDealerId(anyString());
    }
}
