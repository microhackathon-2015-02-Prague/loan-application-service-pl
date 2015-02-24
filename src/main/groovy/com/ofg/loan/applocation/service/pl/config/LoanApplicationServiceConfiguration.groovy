package com.ofg.loan.applocation.service.pl.config

import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import com.ofg.loan.applocation.service.pl.client.FraudDetectorClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
public class LoanApplicationServiceConfiguration {

    @Bean
    FraudDetectorClient colleratorClient(ServiceRestClient serviceRestClient) {
        return new FraudDetectorClient(serviceRestClient)
    }
}
