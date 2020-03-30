# SpringBoot Componentes
|Nome|Descrição
|-|-|
@Bean| resposabiliza o spring pelas instâncias da classe.
@Component|Bean main genérico.
@Service|Bean para anotar classes e regras de negócios.
@Repository|Bean para banco de dados.
@Controller|Bean para requisição.
@Entity|Entidade para o banco de dados. Cria uma tabela no banco.
@AutoWired|ponto de injeção: spring se torna responsável para criar, gerenciar e destruir as instâncias da classe.
@NotEmpty|Validaão: determina que certo atributo não deve retornar vazio.
@RequestMapping|determina a rota do método.
@PathVariable|obtém algum espaço reservado no URI.
@Valid|retorna uma classe válida.
@OneToMany|relação no banco: um __ para muitos __.
@ManyToOne|relação no banco: muitos __ para um __.
@Id|Torna o atributo o Id no banco de dados, a chave primária.
@GeneratedValue|valor gerado pelo spring.
