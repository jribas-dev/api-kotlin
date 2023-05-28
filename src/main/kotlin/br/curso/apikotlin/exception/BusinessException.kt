package br.curso.apikotlin.exception

data class BusinessException(override val message: String?) : RuntimeException(message)