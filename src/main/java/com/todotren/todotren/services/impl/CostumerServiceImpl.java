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
		Costumer costumer = null;
		Costumer newCostumer = mappersConfig.mergerMapper().map(costumerDTO, Costumer.class);
		
		if(costumerRepository.existsBydni(newCostumer.getDni())) {
			Optional<CostumerEntity> optionalOldEntity= costumerRepository.findBydni(costumerDTO.getDni());
			CostumerEntity oldEntity = null;
			if(optionalOldEntity.isPresent()) {
				 oldEntity = optionalOldEntity.get();
			}
			costumer = mappersConfig.mergerMapper().map(oldEntity, Costumer.class);
				

		}else {
			Long id = null;
			List<CostumerEntity> list=costumerRepository.findAll();
			for(CostumerEntity last : list) {
				if(last.getCostumer_id() == null) {
					id = 0L;
					break;
				}
				if(last.getCostumer_id()> id) {
					id = last.getCostumer_id();
				}
			}
			id++;
			costumer = new Costumer();
			costumer.setCostumerId(id);
			costumer.setIdType(newCostumer.getIdType());
			costumer.setDni(newCostumer.getDni());
			
			
			
		}
		costumer.setName(newCostumer.getName());
		costumer.setSurname(newCostumer.getSurname());
		costumer.setAddress(newCostumer.getAddress());
		
		savedEntity = mappersConfig.mergerMapper().map(costumer, CostumerEntity.class);
		return mappersConfig.mergerMapper().map( //mapper that maps a costumer to a costumerDTO
				mappersConfig.mergerMapper().map( //mapper that maps a costumerEntity to a costumer
						costumerRepository.save(savedEntity),Costumer.class), //costumerEntity to costumer
				CostumerDTO.class); //costumerDTO
}
	@Override
    public void deleteByDni(Integer dni){
		
	}
}
