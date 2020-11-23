package br.com.nascimento.customer

import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.PageableRepository

@Repository
@JdbcRepository(dialect = Dialect.POSTGRES)
interface CustomerRepository : PageableRepository<Customer, Long> {

    @Executable
    fun find(nome: String): Customer? = null;


}
