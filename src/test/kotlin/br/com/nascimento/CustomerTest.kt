package br.com.nascimento

import br.com.nascimento.proto.FindByIdRequest
import br.com.nascimento.proto.MicronautGrpcRequest
import br.com.nascimento.proto.MicronautGrpcServiceGrpcKt
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import io.micronaut.grpc.server.GrpcServerChannel
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject
import javax.inject.Singleton


@MicronautTest
class CustomerTest {

    @Inject
    lateinit var customerClient : MicronautGrpcServiceGrpcKt.MicronautGrpcServiceCoroutineStub

    @Test
    fun testHelloWorld() = runBlocking{
        Assertions.assertEquals("Hello Lucas",
            customerClient.helloWorld(MicronautGrpcRequest.newBuilder().setName("Lucas").build()).message)

    }

//    @Test
//    fun testFindById() = runBlocking{
//        Assertions.assertEquals("Lucas",
//            customerClient.findById(FindByIdRequest.newBuilder().setId(1).build()).nome)
//
//    }

}

@Factory
class Client {
    @Singleton
    fun customerClient(
            @GrpcChannel(GrpcServerChannel.NAME) channel: ManagedChannel):
            MicronautGrpcServiceGrpcKt.MicronautGrpcServiceCoroutineStub {
        return MicronautGrpcServiceGrpcKt.MicronautGrpcServiceCoroutineStub(
                channel
        )
    }
}



