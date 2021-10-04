package com.example.demo2.global.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.util.Locale;

@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }

    @PostConstruct
    public void setup() {
        int style = DateFormat.FULL;
        DateFormat dateFormat = DateFormat.getDateInstance(style, Locale.KOREA);
        objectMapper()
                .setDateFormat(dateFormat)
                .enable(SerializationFeature.INDENT_OUTPUT);
    }

}
