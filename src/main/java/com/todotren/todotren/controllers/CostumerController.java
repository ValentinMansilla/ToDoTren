package com.todotren.todotren.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.todotren.todotren.dtos.CostumerDTO;

import com.todotren.todotren.services.CostumerService;

@RestController
@RequestMapping("/costumers")
public class CostumerController {
	
	@Autowired
	private CostumerService costumerService;
	
	
    @GetMapping("/getall")
    public List<CostumerDTO> getAllCostumers() {
    	return costumerService.getAllCostumers();
    	}
    
    @PostMapping("/newcostumer")
    public ResponseEntity<CostumerDTO> newCostumer(@RequestBody CostumerDTO costumerDTO) {
		return ResponseEntity.ok(costumerService.updateCostumer(costumerDTO));
		}
    @PutMapping("/updatecostumer")
    public ResponseEntity<CostumerDTO> updateCostumer(@RequestBody CostumerDTO costumerDTO) {
    			return ResponseEntity.ok(costumerService.updateCostumer(costumerDTO));
    }
    
}
