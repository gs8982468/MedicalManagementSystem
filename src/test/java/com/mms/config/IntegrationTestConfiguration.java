package com.mms.config;

import com.mms.repository.Customer.CustomerRegistrationRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("integrationTest")
@Configuration
public class IntegrationTestConfiguration {

    @Bean
    @Primary
    public CustomerRegistrationRepository getCustomerRegistrationRepository(){
        return Mockito.mock(CustomerRegistrationRepository.class);
    }
}
