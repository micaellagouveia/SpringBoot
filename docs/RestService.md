# Rest Service com SpringBoot
* Serviço de folha de pagamento que gerencia os funcionários de uma empresa.
* Armazenar recursos dos funcionários em um banco de dados de memória H2 e acessá-los via JPA.

## Models

### 1. Employee
* Nome(nome e sobrenome), id gerado automaticamente(@GenerateValue), trabalho.
* Método virtual setName: recebe o nome completo e separa-o em nome e sobrenome.
* Método virtual getName: retorna a concatenação do nome e sobrenome.

### 2. Order
* Descrição, status e id gerado automaticamente.
* Status: enum Status {}. Contém os tipos de status.


## Controllers
### 1. EmployeeController
* Contém rotas de GET, POST, PUT e DELETE.
* Ao invés de utilizar a classe Employee, utiliza a EntityModel e  CollectionModel para postar lista de funcionários.
* Criação dos links relacionados aos objetos criados.
* **EmployeeResourceAssembler**: possui método da conversão de um objeto non-resource (Employee) para um objeto resource-based (EntityModel-Employee-). Linkagem para o próprio objeto e para a lista de funcionários.

### 2. OrderController
* Contém rotas de GET, POST, PUT e DELETE.
* Ao invés de utilizar a classe Employee, utiliza a EntityModel e  CollectionModel para postar lista de funcionários.
* Criação dos links relacionados aos objetos criados.
* **OrderModelAssembler**: método de conversão o non-resource object para resource-based object. Linkagem para as rotas cancel e complete se estiver in_progress.

## Data Configuration
* Foi utilizado o banco do JPA.
* Responsável pelas interações com o banco (save,find, delete)

## Exceptions
* Criação de exceções caso não ache o objeto no banco.