package com.ofg.voters.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String firstName
    String lastName
}
