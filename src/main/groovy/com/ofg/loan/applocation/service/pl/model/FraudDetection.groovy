package com.ofg.loan.applocation.service.pl.model

class FraudDetection {

    String firstName
    String lastName
    String job
    Long amount
    int age

    public static FraudDetection fromLoanApplication(LoanApplication loanApplication) {
        FraudDetection fraudDetection = new FraudDetection()
        fraudDetection.firstName = loanApplication.name
        fraudDetection.lastName = loanApplication.surname
        fraudDetection.job = loanApplication.position.name()
        fraudDetection.amount = loanApplication.amount
        fraudDetection.age = loanApplication.age
        return fraudDetection
    }
}
