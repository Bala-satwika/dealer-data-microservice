package com.tvsmotor.dealerdata.service;

import com.tvsmotor.dealerdata.Model.Dealer;
import com.tvsmotor.dealerdata.Repository.DealerRepository;
import com.tvsmotor.dealerdata.Service.DealerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DealerServiceTest {

    @Mock
    private DealerRepository dealerRepository;

    @InjectMocks
    private DealerService dealerService;

    private Dealer dealer1;
    private Dealer dealer2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Initialize some mock dealers
        dealer1 = new Dealer("1", "D001", "Dealer One", "Address One", 12.9715987, 77.5945627, 
                             "560001", 4.5, "9AM - 6PM", "Sales", "1234567890", 
                             "www.dealerone.com", "Open", "photoUrl1", "ST001", 
                             Arrays.asList("sales", "service"), "State One");
        
        dealer2 = new Dealer("2", "D002", "Dealer Two", "Address Two", 19.0760, 72.8777, 
                             "400001", 4.0, "10AM - 7PM", "Service", "0987654321", 
                             "www.dealertwo.com", "Closed", "photoUrl2", "ST002", 
                             Arrays.asList("sales", "spares"), "State Two");
    }

    @Test
    public void testGetDealersByStateId() {
        // Mock the repository's behavior
        when(dealerRepository.findByStateId("ST001")).thenReturn(Arrays.asList(dealer1));
        
        // Call the service method
        List<Dealer> dealers = dealerService.getDealersByStateId("ST001");
        
        // Assertions
        assertNotNull(dealers);
        assertEquals(1, dealers.size());
        assertEquals("Dealer One", dealers.get(0).getName());

        // Verify interaction with the repository
        verify(dealerRepository, times(1)).findByStateId("ST001");
    }

    @Test
    public void testGetStateNameByStateId() {
        // Mock the repository's behavior
        when(dealerRepository.findFirstByStateId("ST001")).thenReturn(Optional.of(dealer1));
        when(dealerRepository.findFirstByStateId("ST002")).thenReturn(Optional.of(dealer2));
        when(dealerRepository.findFirstByStateId("ST999")).thenReturn(Optional.empty());

        // Call the service method
        String stateName1 = dealerService.getStateNameByStateId("ST001");
        String stateName2 = dealerService.getStateNameByStateId("ST002");
        String stateNameUnknown = dealerService.getStateNameByStateId("ST999");

        // Assertions
        assertEquals("State One", stateName1);
        assertEquals("State Two", stateName2);
        assertEquals("Unknown State", stateNameUnknown);

        // Verify interaction with the repository
        verify(dealerRepository, times(1)).findFirstByStateId("ST001");
        verify(dealerRepository, times(1)).findFirstByStateId("ST002");
        verify(dealerRepository, times(1)).findFirstByStateId("ST999");
    }

    @Test
    public void testGetDealersByStateId_Empty() {
        // Mock an empty result
        when(dealerRepository.findByStateId("ST003")).thenReturn(Arrays.asList());

        // Call the service method
        List<Dealer> dealers = dealerService.getDealersByStateId("ST003");

        // Assertions
        assertNotNull(dealers);
        assertEquals(0, dealers.size());

        // Verify interaction with the repository
        verify(dealerRepository, times(1)).findByStateId("ST003");
    }

    @Test
    public void testGetStateNameByStateId_Empty() {
        // Mock the repository returning empty
        when(dealerRepository.findFirstByStateId("ST999")).thenReturn(Optional.empty());

        // Call the service method
        String stateName = dealerService.getStateNameByStateId("ST999");

        // Assertions
        assertEquals("Unknown State", stateName);

        // Verify interaction with the repository
        verify(dealerRepository, times(1)).findFirstByStateId("ST999");
    }

    @Test
    public void testGetDealersByStateId_MultipleDealers() {
        // Mock the repository returning multiple dealers for the same stateId
        when(dealerRepository.findByStateId("ST001")).thenReturn(Arrays.asList(dealer1, dealer2));

        // Call the service method
        List<Dealer> dealers = dealerService.getDealersByStateId("ST001");

        // Assertions
        assertNotNull(dealers);
        assertEquals(2, dealers.size());
        assertEquals("Dealer One", dealers.get(0).getName());
        assertEquals("Dealer Two", dealers.get(1).getName());

        // Verify interaction with the repository
        verify(dealerRepository, times(1)).findByStateId("ST001");
    }
}
