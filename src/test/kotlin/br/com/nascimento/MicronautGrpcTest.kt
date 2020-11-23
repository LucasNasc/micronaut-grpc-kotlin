package br.com.nascimento
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class MicronautGrpcTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>


}
