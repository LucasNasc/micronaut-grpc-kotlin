package br.com.nascimento.customer

import br.com.nascimento.proto.*
import io.grpc.Status
import io.grpc.StatusException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CustomerEndpoint : MicronautGrpcServiceGrpcKt.MicronautGrpcServiceCoroutineImplBase() {

    @Inject
    lateinit var customerRepository: CustomerRepository

    companion object

    val LOG: Logger = LoggerFactory.getLogger(CustomerEndpoint::class.java.name)

    override suspend fun helloWorld(request: MicronautGrpcRequest): MicronautGrpcReply {

        LOG.info("Starting Hello World..")
        return MicronautGrpcReply.newBuilder().setMessage("Hello ${request.name}").build()

    }

    override suspend fun update(request: UpdateRequest): CustomerReply {

        LOG.info("Updating data...")
        val customer  = isCustomerId(request.customer.id)

        customer.nome = request.customer.nome
        customer.sobrenome = request.customer.sobrenome

        customerRepository.update(customer)

        LOG.info("Done!")
        return CustomerReply.newBuilder()
                .setId(customer.id!!)
                .setNome(customer.nome)
                .setSobrenome(customer.sobrenome)
                .build()

    }

    override suspend fun findById(request: FindByIdRequest): CustomerReply {

        LOG.info("Finding customer...")
        val customer = isCustomerId(request.id)

        LOG.info("Customer by name: ${customer.nome} reached...")
        return CustomerReply.newBuilder()
                .setId(customer.id!!)
                .setNome(customer.nome)
                .setSobrenome(customer.sobrenome)
                .build()

    }

    override suspend fun create(request: CreateRequest): Empty {

        LOG.info("Creating customer...")
        val customer = Customer(
                            id = null,
                            nome = request.nome,
                            sobrenome = request.sobrenome)

        customerRepository.save(customer)

        LOG.info("Customer created...")
        return Empty.getDefaultInstance()

    }

    override suspend fun findByName(request: FindByNameRequest): CustomerReply {
        LOG.info("Finding customer by name...")
        val customer = isCustomerName(request.nome)

        LOG.info("Customer by name: ${customer.nome} reached...")
        return CustomerReply.newBuilder()
                .setId(customer.id!!)
                .setNome(customer.nome)
                .setSobrenome(customer.sobrenome)
                .build()
    }

    override suspend fun listAll(request: ListAllRequest): ListAllResponse {

        LOG.info("Listing customers...")
        val response = ListAllResponse.newBuilder()

        buildCustomerReplyList(response)

        LOG.info("Done")
        return response.build()
    }

    override suspend fun delete(request: DeleteRequest): Empty {
        val customer = isCustomerId(request.id)

        customerRepository.delete(customer)

        return Empty.getDefaultInstance()
    }

    override fun listAllStream(request: ListAllRequest): Flow<CustomerReply> = flow {

        val response = ListAllResponse.newBuilder()

        buildCustomerReplyList(response)
        response.customersBuilderList.forEach() {
            delay(1500)
            emit(
                it.build()
            )
        }
    }

    private fun buildCustomerReplyList(response: ListAllResponse.Builder) {
        customerRepository.findAll().forEach() {
            response.addCustomers(
                    CustomerReply.newBuilder()
                            .setId(it.id!!)
                            .setNome(it.nome)
                            .setSobrenome(it.sobrenome)
                            .build()
            )
        }
    }

    private fun isCustomerId(id: Long): Customer {
        return customerRepository
                .findById(id)
                .map { Customer(it.id, it.nome, it.sobrenome) }
                .orElseThrow { StatusException(Status.NOT_FOUND) }
    }

    private fun isCustomerName(nome: String): Customer {
        return customerRepository
                .find(nome) ?: throw StatusException(Status.NOT_FOUND)
    }

}
