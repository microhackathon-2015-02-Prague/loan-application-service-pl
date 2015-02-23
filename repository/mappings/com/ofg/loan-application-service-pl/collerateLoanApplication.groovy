io.coderate.accurest.dsl.GroovyDsl.make {
    request {
        method 'PUT'
        url '/api/loanApplication'
        headers {
            header 'Content-Type': 'application/vnd.com.ofg.twitter-places-analyzer.v1+json'
        }
        body '''\
    [{
        "name": "Sat Jul 26 09:38:57 +0000 2014",
        "surname": 492967299297845248,
        "age": "492967299297845248",
        "jobpossition": "Gonna see you at Warsaw",
        "amount": "Gonna see you at Warsaw"
    }]
'''
    }
    response {
        status 200
    }
}