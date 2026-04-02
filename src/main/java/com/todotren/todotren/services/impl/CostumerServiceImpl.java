package com.todotren.todotren.services.impl;

import com.todotren.todotren.config.MappersConfig;
import com.todotren.todotren.dtos.CostumerDTO;
import com.todotren.todotren.entities.CostumerEntity;
import com.todotren.todotren.models.Costumer;
import com.todotren.todotren.repositories.CostumerRepository;
import com.todotren.todotren.services.CostumerService;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerServiceImpl implements CostumerService {
	
	@Autowired
	private CostumerRepository costumerRepository;
    @Autowired
    private MappersConfig mappersConfig;
	
	@Override
    public List<CostumerDTO> getAllCostumers() { 
		return mappersConfig.mergerMapper().map( //mapper that maps a list of costumers to a list of costumerDTOs
				mappersConfig.mergerMapper().map( //mapper that maps a list of costumerEntities to a list of costumers
						costumerRepository.findAll(), new TypeToken<List<Costumer>>(){}.getType()), //costumerEntites to costumers
				new TypeToken<List<CostumerDTO>>(){}.getType()); //costumerDTOs
	}
	@Override
    public CostumerDTO getByDni(Integer dni) {
		return null;}
	@Override
    public CostumerDTO updateCostumer(CostumerDTO costumerDTO) {
		CostumerEntity savedEntity = null;
		
		if(costumerRepository.existsByDNI(costumerDTO.getDni())) {
			Optional<CostumerEntity> optionalOldEntity= costumerRepository.findByDNI(costumerDTO.getDni());
			CostumerEntity oldEntity = null;
			if(optionalOldEntity.isPresent()) {
				 oldEntity = optionalOldEntity.get();
			}
			Costumer oldCostumer = mappersConfig.mergerMapper().map(oldEntity, Costumer.class);
			Costumer newCostumer = mappersConfig.mergerMapper().map(costumerDTO, Costumer.class);
			
			oldCostumer.setName(newCostumer.getName());
			oldCostumer.setSurname(newCostumer.getSurname());
			oldCostumer.setAddress(newCostumer.getAddress());
			
			savedEntity = mappersConfig.mergerMapper().map(oldCostumer, CostumerEntity.class);
			return mappersConfig.mergerMapper().map( //mapper that maps a costumer to a costumerDTO
					mappersConfig.mergerMapper().map( //mapper that maps a costumerEntity to a costumer
							costumerRepository.save(savedEntity),Costumer.class), //costumerEntity to costumer
					CostumerDTO.class); //costumerDTO
			

		}else {
			Long id = null;
			List<CostumerEntity> list=costumerRepository.findAll();
			for(CostumerEntity last : list) {
				if(last.getCostumer_id()> id) {
					id = last.getCostumer_id();
				}
			}
			
		}

		Costumer costumer = mappersConfig.mergerMapper().map(costumerDTO, Costumer.class);
		
		
		return costumerDTO;}
	@Override
    public void deleteByDni(Integer dni){
		
	}
}
