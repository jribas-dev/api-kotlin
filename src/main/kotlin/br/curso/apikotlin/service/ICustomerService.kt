package br.curso.apikotlin.service

import br.curso.apikotlin.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}