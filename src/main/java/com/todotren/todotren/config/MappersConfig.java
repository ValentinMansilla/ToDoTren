package com.todotren.todotren.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
/**
 * Fabricator of ModelMapper() objects and ObjectMapper() objects
 * @see ModelMapper
 * @see ObjectMapper
 */
public class MappersConfig {


        private static MappersConfig mappersConfig;

        private MappersConfig(){
        }

        /**
         * @return a unique instance of this class
         */
        public static MappersConfig getModelMapper(){
            if(mappersConfig == null){
                mappersConfig = new MappersConfig();
            }
            return mappersConfig;
        }


        /**
         * @return  a new instane of ModelMapper
         */
        public ModelMapper mergerMapper(){
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            return mapper;
        }
        /**
         * @return  a new instance of ObjectMapper
         */
        public ObjectMapper objectMapper(){
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper;
        }


}
