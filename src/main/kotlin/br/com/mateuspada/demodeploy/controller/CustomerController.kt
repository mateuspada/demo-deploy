package br.com.mateuspada.demodeploy.controller

import br.com.mateuspada.demodeploy.domain.Customer
import org.springframework.http.ResponseEntity


interface CustomerController {

    fun getCustomer(): List<Customer>

    fun insertCustomer(customer: Customer): ResponseEntity<Any>

}