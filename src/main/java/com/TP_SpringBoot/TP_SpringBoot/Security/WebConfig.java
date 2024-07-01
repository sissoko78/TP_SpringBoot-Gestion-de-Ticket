package com.TP_SpringBoot.TP_SpringBoot.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;

@Configuration
public class WebConfig {
    @Bean
    public MappingJackson2CborHttpMessageConverter jsonConverter(){
        return new MappingJackson2CborHttpMessageConverter();
    }
}
