package com.todotren.todotren.services.impl;

import com.todotren.todotren.config.MappersConfig;
import com.todotren.todotren.dtos.CostumerDTO;
import com.todotren.todotren.entities.CostumerEntity;
import com.todotren.todotren.entities.TypeIdEntity;
import com.todotren.todotren.models.Costumer;
import com.todotren.todotren.repositories.CostumerRepository;
import com.todotren.todotren.repositories.TypeIdRepository;
import com.todotren.todotren.services.CostumerService;

import jakarta.transaction.Transactional;

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
    @Autowired
    private TypeIdRepository typeIdRepository;
	
	@Override
    public List<CostumerDTO> getAllCostumers() { 
		return  mappersConfig.mergerMapper().map(costumerRepository.findAll(), new TypeToken<List<CostumerDTO>>(){}.getType()); //costumerDTOs
	}
	@Override
    public CostumerDTO getByDni(Integer dni) {
		return null;}
	@Override
	@Transactional
    public CostumerDTO updateCostumer(CostumerDTO costumerDTO) {
		CostumerEntity savedEntity = new CostumerEntity();
		TypeIdEntity typeIdentity = new TypeIdEntity();
		
		Optional<TypeIdEntity> optionalTypeIdEntity = typeIdRepository.findBytipe(costumerDTO.getIdType());
		if(optionalTypeIdEntity.isPresent()) {
			typeIdentity = optionalTypeIdEntity.get();
		}
		
		if(costumerRepository.existsBydni(costumerDTO.getDni())) {
			Optional<CostumerEntity> optionalOldEntity= costumerRepository.findBydni(costumerDTO.getDni());
			CostumerEntity oldEntity = null;
			if(optionalOldEntity.isPresent()) {
				 oldEntity = optionalOldEntity.get();
			}
			savedEntity.setCostumer_id(oldEntity.getCostumer_id());
			
		}else {
			
			Long id = null;
			List<CostumerEntity> list=costumerRepository.findAll();
			if(list.isEmpty()) {
				id = 0L;
				}
			else {
				for(CostumerEntity last : list) {
				
				if(id == null || last.getCostumer_id()> id) {
					id = last.getCostumer_id();
				}
				id++;

				}
			
				
			}
			savedEntity.setCostumer_id(id);
		}
		savedEntity.setIdType(typeIdentity);
		savedEntity.setDni(costumerDTO.getDni());
		savedEntity.setName(costumerDTO.getName());
		savedEntity.setSurname(costumerDTO.getSurname());
		savedEntity.setAddress(costumerDTO.getAddress());
	
		CostumerDTO savedDTO =mappersConfig.mergerMapper().map(costumerRepository.save(savedEntity),CostumerDTO.class);
		return savedDTO;
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Costumer costumer = null;
		Costumer dtoCostumer = mappersConfig.mergerMapper().map(costumerDTO, Costumer.class);
		if(costumerRepository.existsBydni(dtoCostumer.getDni())) {
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
			costumer.setIdType(dtoCostumer.getIdType());
			costumer.setDni(dtoCostumer.getDni());
			
			
			
		}
		costumer.setName(dtoCostumer.getName());
		costumer.setSurname(dtoCostumer.getSurname());
		costumer.setAddress(dtoCostumer.getAddress());
		
		savedEntity = mappersConfig.mergerMapper().map(costumer, CostumerEntity.class);
		return mappersConfig.mergerMapper().map( //mapper that maps a costumer to a costumerDTO
				mappersConfig.mergerMapper().map( //mapper that maps a costumerEntity to a costumer
						costumerRepository.save(savedEntity),Costumer.class), //costumerEntity to costumer
				CostumerDTO.class); //costumerDTO
				*/
}
	@Override
    public void deleteByDni(Integer dni){
		
	}
}
