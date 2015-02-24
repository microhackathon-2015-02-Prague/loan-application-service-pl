package com.ofg.loan.applocation.service.pl.service

import com.ofg.loan.applocation.service.pl.client.FraudDetectorClient
import com.ofg.loan.applocation.service.pl.model.FraudDetection
import com.ofg.loan.applocation.service.pl.model.LoanApplication
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.hibernate.cfg.AnnotationConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull
import java.util.concurrent.Callable

import static com.ofg.loan.applocation.service.pl.config.Versions.LOAN_APPLICATION_SERVICE_JSON_VERSION_1
import static org.springframework.web.bind.annotation.RequestMethod.POST


@Slf4j
@RestController
@RequestMapping('/api')
@TypeChecked
@Api(value = "loan-application-service-pl", description = "Create loan application for Poland")
class LoanApplicationController {

    @Autowired
    FraudDetectorClient fraudDetectorClient;

    @RequestMapping(
            value = '{loanApplication}',
            method = POST,
            consumes = LOAN_APPLICATION_SERVICE_JSON_VERSION_1,
            produces = LOAN_APPLICATION_SERVICE_JSON_VERSION_1)
    @ApiOperation(value = "generate loan application",
            notes = "This bla blah blah")
    Callable<Void> getLoanApplication(@RequestBody @NotNull LoanApplication loanApplication) {
        FraudDetection fraudDetection = FraudDetection.fromLoanApplication(loanApplication)
        //saveLoanApp(loanApplication)
        fraudDetectorClient.putFraud("123", fraudDetection)
        return {
            System.out.println(loanApplication.name)
            System.out.println(loanApplication.surname)
            System.out.println(loanApplication.position)
            System.out.println(loanApplication.age)
            System.out.println(loanApplication.amount)
        }
    }

    /*def hibProps = [
            "hibernate.dialect": "org.hibernate.dialect.HSQLDialect",
            "hibernate.connection.driver_class": "org.hsqldb.jdbcDriver",
            "hibernate.connection.url": "jdbc:hsqldb:mem:demodb",
            "hibernate.connection.username": "sa",
            "hibernate.connection.password": "",
            "hibernate.connection.pool_size": "1",
            "hibernate.connection.autocommit": "true",
            "hibernate.cache.provider_class": "org.hibernate.cache.NoCacheProvider",
            "hibernate.hbm2ddl.auto": "create-drop",
            "hibernate.show_sql": "true",
            "hibernate.transaction.factory_class": "org.hibernate.transaction.JDBCTransactionFactory",
            "hibernate.current_session_context_class": "thread"
    ]

    def configureHibernate(props) {
        def config = new AnnotationConfiguration()
        props.each { k, v -> config.setProperty(k, v) }
        config.addAnnotatedClass(LoanApplication)
        return config
    }

    void saveLoanApp(LoanApplication loanApplication) {
        def factory = configureHibernate(hibProps).buildSessionFactory()

        def session = factory.currentSession
        def tx = session.beginTransaction()
        session.save(loanApplication)
        tx.commit()
    }*/
}
