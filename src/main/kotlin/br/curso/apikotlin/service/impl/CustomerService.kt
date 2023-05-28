package br.curso.apikotlin.service.impl

import br.curso.apikotlin.entity.Customer
import br.curso.apikotlin.exception.BusinessException
import br.curso.apikotlin.repository.CustomerRepository
import br.curso.apikotlin.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
    ): ICustomerService {
    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id)
            .orElseThrow {
                throw BusinessException("Id $id not found")
            }
    }

    override fun delete(id: Long) {
        val customer: Customer = this.customerRepository.findById(id)
            .orElseThrow {
                throw BusinessException("Id $id not found")
            }
        this.customerRepository.delete(customer)
    }
}