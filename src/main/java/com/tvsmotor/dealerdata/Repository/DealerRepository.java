package com.tvsmotor.dealerdata.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.tvsmotor.dealerdata.Model.Dealer;

import java.util.List;
import java.util.Optional;

public interface DealerRepository extends MongoRepository<Dealer, String> {
    List<Dealer> findByStateId(String stateId);
   
	Optional<Dealer> findFirstByStateId(String stateId);

}
