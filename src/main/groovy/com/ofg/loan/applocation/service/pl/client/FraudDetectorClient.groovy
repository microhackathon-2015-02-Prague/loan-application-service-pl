package com.ofg.loan.applocation.service.pl.client

import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import com.ofg.loan.applocation.service.pl.model.FraudDetection
import groovy.transform.CompileStatic


@CompileStatic
class FraudDetectorClient {

    private final ServiceRestClient serviceRestClient

    FraudDetectorClient(ServiceRestClient serviceRestClient) {
        this.serviceRestClient = serviceRestClient
    }

    void putFraud(String loanId, FraudDetection fraudDetection) {
        serviceRestClient.forService("fraud-detection-service-pl")
                .post()
                .onUrlFromTemplate("/{loanId}").withVariables(loanId)
                .body(fraudDetection)
                .anObject()
                .ofType(String)
    }

}
