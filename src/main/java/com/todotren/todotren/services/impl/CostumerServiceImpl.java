package com.todotren.todotren.services.impl;

import com.todotren.todotren.dtos.CostumerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CostumerServiceImpl {
    List<CostumerDTO> getAllCostumers();
    CostumerDTO getByDni(Integer dni);
    CostumerDTO updateCostumer(CostumerDTO costumerDTO);
    void deleteByDni(Integer dni);
}
