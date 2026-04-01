package com.todotren.todotren.services;

import com.todotren.todotren.dtos.CostumerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CostumerService {
    List<CostumerDTO> getAllCostumers();
    CostumerDTO getByDni(Integer dni);
    CostumerDTO updateCostumer(CostumerDTO costumerDTO);
    void deleteByDni(Integer dni);
}
