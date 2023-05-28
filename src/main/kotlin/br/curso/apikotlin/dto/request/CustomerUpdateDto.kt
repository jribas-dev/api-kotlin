package br.curso.apikotlin.dto.request

import br.curso.apikotlin.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    var firstName: String = "",
    var lastName: String = "",
    var income: BigDecimal = BigDecimal.ZERO,
    var zipCode: String = "",
    var street: String = ""
) {

    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode
        return customer
    }
}
