package br.com.mateuspada.demodeploy.domain

import java.util.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class Customer(
    @field:[NotNull(message = "Não pode ser nulo")] val id: UUID?,
    @field:[NotEmpty(message ="Não pode ser vazio")] val name: String?
)