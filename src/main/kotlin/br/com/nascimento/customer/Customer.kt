package br.com.nascimento.customer

import javax.persistence.*

@Entity
data class Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,

        var nome: String,

        var sobrenome: String)
{}
