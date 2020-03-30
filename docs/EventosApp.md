# Eventos App
* Aplicação para cadastro de eventos. Podendo adicionar nome do evento, lugar, data e horário.
* Para cada evento há uma lista de convidados, contendo nome e rg de cada convidado.
* Os dados, tanto do evento quanto dos convidados são armazenados em um banco de dados MySQL.

## 1. Criação do Index
Página incial da aplicação.
* Criação da IndexController: atribui página como @Controller e faz um método @RequestMapping("/") que retorna o index.html.(Ou seja, no endereço inicial a página index será atribuída)
* Criação do index.html

## 2. MVC para Evento e Convidado
* Model: Classe evento e convidado.
* Controller: EventoController. Faz os @RequestMapping do cadastro de eventos, da lista de eventos e de cada evento específico(a partir do seu código gerado).
* View: formEvento e detalhesEvento:
1) Formulário para cadastro de eventos. No próprio index.html referenciamos a lista de eventos.
2) Detalhes do evento específico gerado por código.

## 3. Configuração do Banco MySQL
Necessita de depencdências JPA, MySQL, Hibernate, H2 Dependency.
* application.properties : ativação do hibernate, set do datasource(URL, nome do usuário e senha).
* EventoRepository e ConvidadoRepository: crud para ter acesso à metodos de acesso ao banco.
* model Evento: gerar código automático para cada evento (@Id e @GeneratedValue). Também gerar uma lista de convidados (@OneToMany)
* model Convidado: gerar um evento (@ManyToOne) e tornar o RG o @Id (único para cada pessoa).
* @OneToMany e @ManyToOne fazem a relação no banco de dados entre evento e convidado. Há um evento para vários convidados, e há vários convidados para um evento.
* A tabela de convidados recebe o código do evento designado. 

## 4. Deletar Convidado ou Evento do Banco
Criação do método de deletar.
* Evento: recebe o código do evento, encontra evento no banco e deleta. Retorna a lista de eventos.
* Convidado: recebe rg do convidado. Encontra convidado pelo RG, deleta convidado. Pega o código do evento relacionado ao convidado e redireciona para a página do detalhe do evento específico.

## 5. Validação de Dados
Enviar formulários de cadastramento de eventos e convidados apenas se todos os campos estiverem preenchidos.
* @NotEmpty atributos.
* @Valid Convidado ou @Valid Evento.
* Se não for valido, haverá um erro, e retornará uma mensagem de erro.
* Se for valido e salvar no banco, retornará uma mensagem de sucesso.
## Style: Materialize
* Repositório para estilização/css das páginas html.

