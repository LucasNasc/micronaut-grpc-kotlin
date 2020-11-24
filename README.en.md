<h1 align="center"> Micronaut + gRPC + kotlin </h1>



<p>
  <img alt="Version" src="https://img.shields.io/badge/version-0.1-blue.svg?cacheSeconds=2592000" />
</p>

  > An application using a framework [micronaut](https://micronaut.io/), in communication the <b>[gRPC](https://grpc.io/)</b>, an RPC framework for communication between services (back-end, front-end, mobile, microservices ...). Using postgres as a database and kotlin as a programming language.
  
  
 ## Technology
- Java 11
- Gradle
- Micronaut 2.1.4
    - micronaut-validation
    - micronaut-kotlin-runtime
    - micronaut-grpc-runtime
    - micronaut-jdbc-hikari
    - micronaut-data-jdbc
    - micronaut-data-processor
    - micronaut-test
 - [gRPC](#grpc)
 - Logback
 - Git
 - Postgres
 
## Micronaut
> It is a framework focused on creating microservices and serverless applications, which focuses on speed and low memory consumption using 3 JVM-based languages (Java, Kotlin and Groovy).

## gRPC
> communication framework that has been well-received in the community, as it uses HTTP2 as a communication protocol and has, by default, the <b> Protocol Buffer </b> as a data serialization mechanism (however it is possible to use other data mechanisms such as JSON), below is an excerpt of the representation of an "object" in the ".proto" extension file:

```
message CustomerReply {
  uint64 id = 1;
  string nome = 2;
  string sobrenome = 3;
}
```

> One of the advantages of this new "model" of communication is that it is possible to send and receive a data stream. In the application it is possible to find a proto-response model using stream (in the ListAllStream method, located in the [CustomerEndpoint.kt](https://github.com/LucasNasc/micronaut-grpc-kotlin/blob/master/src/main /kotlin/br/com/nascimento/customer/CustomerEndpoint.kt)) 

## Installing Dependencies

> The package manager used in the project is gradle, so it is necessary first of all, to install the dependencies through the command: 

```sh
./gradlew build
```

## Running the project

> In the "src / docker" directory there is a docker-compose with the database settings, to upload the bank run the command: 

```sh
docker-compose up
```

> After database up, run application with this command: 

```sh
./gradlew run
```

### Testing application

> The application has 2 automated tests in order to present the operation of the micronaut-test to run them just using the following command:

```sh
./gradlew test
```

> To test your gRPC requests with the protocol buffer serialization standard, you can use BloomRPC, which works very similar to postman and insmonia to test REST requests, you can download BloomRPC through [here] (https: / /appimage.github.io/BloomRPC/). With it open, just import your file with a .proto extension, and it already recognizes your contract and presents all the included methods to run.



## Author

👤 **Lucas Nascimento**

* Github: [@LucasNasc](https://github.com/LucasNasc)
* LinkedIn: [@lucaspnascimento](https://linkedin.com/in/lucaspnascimento)

## Show your support

Give a ⭐️ if this project helped you!
