# Car Logging - API REST

Neste projeto desenvolvi um sistema para o gerenciamento de carros e registro de logs através de uma API REST consumida externamente, o projeto foi criado com o Spring Boot e MongoDB.

## Instruções necessárias para iniciar a aplicação:

- Clonar o repositório no terminal:

 ```shell script
git clone https://github.com/rafaelofficial/apirest.git 
```

- Por fim, basta acessar a pasta do seu repositório clonado, com o seguinte comando:

```shell script
cd apirest
```
- Criar uma database de nome "test" no [MongoDB Compass](https://www.mongodb.com/pt-br/products/compass), com as collections de nome: "cars" e "logs". <br>PS: As configurações encontram-se no arquivo application.properties

- Para executar o MongoDB no terminal, digite o seguite comando e em seguida conectar ao MongoDB Compass:

```shell script
mongod
```

## Executando o projeto:

- Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Ou se preferir você pode importar projeto na sua IDE de preferencia. Utilizei o [Spring Tools 4 for Eclipse](https://spring.io/tools/) para desenvolver essa aplicação:

Ao abrir, você verá a interface do STS. Olhando na parte superior você verá um menu, selecione:

- File > Import > Maven > Existing Maven Projects > Next e Selecione o projeto em 
 Root Directory - Browser, basta acessar a pasta do seu repositório clonado e rodar a aplicação;

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto (Postman ou no Navegador):

## Exemplos para testar os endpoints:

- GET - Listar todos os carros:

```
http://localhost:8080/api/listCars
```

- GET - Listar carro pelo id:

```
http://localhost:8080/api/listCars/62e04accf8037d001c59e5d0
```

- POST - Criar um novo carro:

```
http://localhost:8080/api/createCar
```

- GET - Listar os logs: 
PS: Atualizar o base de dados do log para obter os últimos registros na api.

```
http://localhost:8080/api/logs
```

São necessários os seguintes pré-requisitos para a execução do projeto:

- Java 17.
- Maven 3.6.3 ou versões superiores.
- Spring Tools Suite ou sua IDE favorita.
- MongoDB Compass.
- Postman (para testar os endpoints).
- Controle de versão GIT instalado na sua máquina :)

Abaixo, seguem links bem bacanas, sobre tópicos utilizados como referências para desenvolver este projeto:

- [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)
- [Spring Tools 4 for Eclipse](https://spring.io/tools/)
- [Site oficial do Spring](https://spring.io/)
- [Site oficial do Spring Initialzr, para setup do projeto](https://start.spring.io/)
- [Site oficial do MongoDB Compass](https://www.mongodb.com/pt-br/products/compass)
- [Site oficial do Postman](https://www.postman.com/downloads/)
- [Site oficial do Baeldung - Spring Boot](https://www.baeldung.com/spring-boot)
