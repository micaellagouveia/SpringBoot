# Envio de Mensagens com RabbitMQ
* Pequeno exemplo de como funciona a publicação de uma mensagem usando o Spring AMQP’s RabbitTemplate e assinar a mensagem em um POJO (objetos Java que seguem um desenho simplificado) usando o MessageListenerAdapter.

## Receiver
* Receptor das mensagens.
* @Component
* CountDownLatch : usado para garantir que uma tarefa aguarde outras threads antes de iniciar. Manda uma sinal quando recebe a mensagem.
* Criação do método para receber as mensagens.

## Listener (Application)
* Configuração do container listener.
* Declaração da queue, exchange e binding entre elas.
* Configuração de uma component para mandar as mensagens para o listener. (**Receiver**)
* O Springboot já cria automaticamente a conexão com o servidor do Rabbit e o RabbitTemplate.
* MessageListenerAdapter: recebe o receiver e retorna um o listener receiver.

## Runner (Enviar Mensagem)
* CommandLineRunner: envia a mensagem, além de esperar o sinal do Receiver e fecha a aplicação.
* @Component
* @Override: roda a espera da mensagem.
* Conversão do template e envio com a routingkey e a mensagem.