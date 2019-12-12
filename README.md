# kafka_poc
Projeto utilizado na apresentação do kafka ao time

  - Há um exemplo de producer e listener, bem como, class de configuração
  - Há um exemplo da Bean para que a aplicação crie os topics (basico de configuração)
  
  
  Para executar o projeto, importe como um projeto MAVEN em sua IDE
  
    - O primeiro passo é subir o Zookeeper e depois o kafka (conforme QuickStart abaixo)
    - A porta configurada no yml deste projeto para conectar ao Kafka é a 9092 (padrão do Kafka)
    - Ao subir o projeto pela primeira vez ele irá conectar ao Kafka, criará um topic chamado example_topic
      - Após o projeto iniciar, há um evento na class TestProducer que envia uma msg ao topic criado (example_topic)
      - A class OrderConsumer possui um listener no mesmo topic (example_topic) cuja a implementação é ler e "imprimir" a msg no console
      - No yml, há uma configuração chamada "offsetConfig":  onde inserindo "earliest" o consumer irá consumir todas as msg do topic desde o inicio e "latest" o consumer irá ler a partir da ultima msg.


# Download Kafka
https://kafka.apache.org/downloads

# QuickStart
https://kafka.apache.org/documentation/#quickstart
(Este foi o passo a passo seguido na apresentação

# KafkaTool (Para acessar mensagens)
http://www.kafkatool.com/

# Passo a passo para configurar kafka no seu projeto 
https://www.baeldung.com/spring-kafka


