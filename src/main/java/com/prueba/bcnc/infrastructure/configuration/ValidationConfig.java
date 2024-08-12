package com.prueba.bcnc.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * The type Validation config.
 */
@Configuration
public class ValidationConfig {

    /**
     * Validator local validator factory bean.
     *
     * @return the local validator factory bean
     */
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

}
