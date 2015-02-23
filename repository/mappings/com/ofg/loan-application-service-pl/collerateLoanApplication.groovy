io.coderate.accurest.dsl.GroovyDsl.make {
    request {
        method 'PUT'
        url '/api/loanApplication'
        headers {
            header 'Content-Type': 'application/vnd.com.ofg.loan-application-service-pl.v1+json'
        }
        body '''\
    [{
         "name": "X",
         "position": "IT",
         "amount": 100,
         "age": 40,
         "surname": "Y"
    }]
'''
    }
    response {
        status 200
    }
}