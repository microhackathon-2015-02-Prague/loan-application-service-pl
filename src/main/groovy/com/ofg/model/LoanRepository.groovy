package com.ofg.voters.model

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param


interface LoanRepository extends PagingAndSortingRepository<Loan, Long> {
}
