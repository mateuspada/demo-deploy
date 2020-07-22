package br.com.mateuspada.demodeploy.domain

import org.jetbrains.annotations.NotNull
import java.util.*
import javax.validation.constraints.NotEmpty

data class Customer(
    @field:[NotNull] val id: UUID?,
    @field:[NotEmpty] var name: String?
)