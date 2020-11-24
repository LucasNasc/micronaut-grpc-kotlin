<h1 align="center"> Micronaut + gRPC + kotlin </h1>



<p>
  <img alt="Version" src="https://img.shields.io/badge/version-0.1-blue.svg?cacheSeconds=2592000" />
</p>

  > Uma aplicação utilizando um framework [micronaut](https://micronaut.io/), utilizando na comunicação o <b>[gRPC](https://grpc.io/)</b>, um framework RPC de comunicação entre serviços(back-end, front-end, mobile, microserviços... ). Utilizando postgres como banco de dados e kotlin como linguagem de programação.
  
  
 ## Tecnologias
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
> É um framework com foco de criação de microserviços e aplicações serverless, que tem como foco velocidade e pouco consumo de memória utilizando 3 linguagens JVM-based ( Java, Kotlin e Groovy ).

## gRPC
> framework de comunicaçãoque vem sendo bem repercutido  no mercado, pois utiliza como protocolo de comunicação o HTTP2 e tem por padrão, o <b> Protocol Buffer </b> como mecanismo de serialização de dados( porém é possível utilizar outros mecanismos de dados como JSON ), abaixo segue o trecho da representação de um "objeto" no arquivo de extensão ".proto" :

```
message CustomerReply {
  uint64 id = 1;
  string nome = 2;
  string sobrenome = 3;
}
```

> Um dos diferenciais desse novo "modelo" de comunicação é que possivel enviar e receber um stream de dados. Na aplicação é possivel encontrar um modelo de proto-response utilizando stream ( no método ListAllStream, localizado no arquivo [CustomerEndpoint.kt](https://github.com/LucasNasc/micronaut-grpc-kotlin/blob/master/src/main/kotlin/br/com/nascimento/customer/CustomerEndpoint.kt)) 

## Instalando Dependências
> O gerenciador de pacotes utilizado no projeto é o gradle, então é necessário antes tudo, instalar as dependências através do comando: 

```sh
./gradlew build
```

## Rodando o Projeto

> No diretório "src/docker" tem um docker-compose com a configurações do banco de dados, para subir o banco rodar o comando no : 

```sh
docker-compose up
```
> Após o subir o banco rodar o seguinte comando para subir a aplicação:

```sh
./gradlew run
```

### Testando a aplicação

> A aplicação possui 2 testes automatizados com o objetivo de apresentar o funcionamento do micronaut-test para roda-los bastar utilizar o seguinte comando:

```sh
./gradlew test
```
> Para testar suas resquisições gRPC com o padrão de serialização proto-buffer, pode-se utilizar o BloomRPC, que funciona bem semelhante ao postman e insmonia para testar a requisições REST, você pode fazer o download do BloomRPC por [aqui](https://appimage.github.io/BloomRPC/). Com ele aberto, basta importar  seu arquivo com extensão .proto, e ele já reconhece seu contrato e apresenta todos os metodos inclusos para rodar.


## Author

👤 **Lucas Nascimento**

* Github: [@LucasNasc](https://github.com/LucasNasc)
* LinkedIn: [@lucaspnascimento](https://linkedin.com/in/lucaspnascimento)

## Show your support

Give a ⭐️ if this project helped you!
