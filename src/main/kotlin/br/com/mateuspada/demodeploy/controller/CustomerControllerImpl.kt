package br.com.mateuspada.demodeploy.controller

import br.com.mateuspada.demodeploy.domain.Customer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/customer")
class CustomerControllerImpl : CustomerController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    override fun getCustomer(): List<Customer> {
        return CustomerDatabase.customerList
    }

    @PostMapping
    override fun insertCustomer(@Valid @RequestBody customer: Customer): ResponseEntity<Any> {

        return if (CustomerDatabase.customerList.none { it.id == customer.id }) {
            CustomerDatabase.customerList.add(customer)
            ResponseEntity(HttpStatus.CREATED)
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }

    }


}

object CustomerDatabase {
    val customerList = mutableListOf<Customer>()
}