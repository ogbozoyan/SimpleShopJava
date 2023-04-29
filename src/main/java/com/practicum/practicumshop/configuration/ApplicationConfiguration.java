package com.practicum.practicumshop.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean(name = "patchingMapper")
    ModelMapper patchingModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setSkipNullEnabled(true)
                .setCollectionsMergeEnabled(false)
                .setPropertyCondition(Conditions.isNotNull());
        return modelMapper;
    }

    @Bean(name = "objectWritter")
    ObjectWriter objectWriter() {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        return mapper.writer().withDefaultPrettyPrinter();
    }
}
