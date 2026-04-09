package com.todotren.todotren.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.todotren.todotren.dtos.CostumerDTO;
import com.todotren.todotren.entities.CostumerEntity;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fabricator of ModelMapper() objects and ObjectMapper() objects
 * @see ModelMapper
 * @see ObjectMapper
 */
@Configuration
public class MappersConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean("mergerMapper")
    public ModelMapper mergerMapper() {
        ModelMapper modelMapper =  new ModelMapper();
        
        modelMapper.getConfiguration()
                .setPropertyCondition(Conditions.isNotNull());
        modelMapper.typeMap(CostumerEntity.class, CostumerDTO.class).addMappings(
        		mapper ->{
        			mapper.map(fuente -> fuente.getIdType().getTipe(), CostumerDTO::setIdType);
        		});
        return modelMapper;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }


}
