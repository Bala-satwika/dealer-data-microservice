package com.tvsmotor.dealerdata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tvsmotor.dealerdata.Model.Dealer;
import com.tvsmotor.dealerdata.Service.DealerService;

import java.util.List;

@RestController
@RequestMapping("/dealers")
@CrossOrigin("*")
public class DealerController {

    @Autowired
    private DealerService dealerService;

    @GetMapping("/{stateId}")
    public List<Dealer> getDealersByStateId(@PathVariable String stateId) {
        return dealerService. getDealersByStateId(stateId);
    }
    @GetMapping("/stateName/{stateId}")
    public String getStateNameByStateId(@PathVariable String stateId) {
        return dealerService.getStateNameByStateId(stateId);
    }

  
}
