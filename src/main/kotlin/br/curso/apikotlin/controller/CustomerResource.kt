package br.curso.apikotlin.controller

import br.curso.apikotlin.dto.request.CustomerDto
import br.curso.apikotlin.dto.request.CustomerUpdateDto
import br.curso.apikotlin.dto.response.CustomerView
import br.curso.apikotlin.entity.Customer
import br.curso.apikotlin.exception.BusinessException
import br.curso.apikotlin.service.impl.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/customers")
class CustomerResource(private val customerService: CustomerService) {

    @PostMapping
    fun saveCustomer(
        @RequestBody
        @Valid customerDto: CustomerDto
    ): ResponseEntity<CustomerView> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            CustomerView(this.customerService.save(customerDto.toEntity()))
        )
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long): ResponseEntity<Map<String, String>> {
        return try {
            this.customerService.delete(id)
            ResponseEntity.status(HttpStatus.OK).body(mapOf("msg" to "Customer $id has benn deleted"))
        } catch (e: BusinessException) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapOf("msg" to "Customer with ${e.message}"))
        }
    }

    @PatchMapping
    fun upadateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody customerUpdateDto: CustomerUpdateDto
    ): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)

        if (customerUpdateDto.firstName.isEmpty()) { customerUpdateDto.firstName = customer.firstName }
        if (customerUpdateDto.lastName.isEmpty()) { customerUpdateDto.lastName = customer.lastName }
        if (customerUpdateDto.income == BigDecimal.ZERO) { customerUpdateDto.income = customer.income }
        if (customerUpdateDto.zipCode.isEmpty()) { customerUpdateDto.zipCode = customer.address.zipCode }
        if (customerUpdateDto.street.isEmpty()) { customerUpdateDto.street = customer.address.street }

        val customerUpdated: Customer = this.customerService.save(
            customerUpdateDto.toEntity(customer)
        )
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }
}