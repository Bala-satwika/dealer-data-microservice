package com.tvsmotor.dealerdata.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvsmotor.dealerdata.Model.Dealer;

import com.tvsmotor.dealerdata.Model.Order;
import com.tvsmotor.dealerdata.Repository.DealerRepository;
import com.tvsmotor.dealerdata.Repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DealerService {

    @Autowired
    private DealerRepository dealerRepository;

   
    public List<Dealer> getDealersByStateId(String stateId) {
        return dealerRepository.findByStateId(stateId);
    }

    // Fetch state name based on stateId
    public String getStateNameByStateId(String stateId) {
        Optional<Dealer> dealer = dealerRepository.findFirstByStateId(stateId);
        return dealer.map(Dealer::getState).orElse("Unknown State");
    }

    

  
}
