# Event Driven Microservice example
* Spring Boot 2
* RabbitMQ
* code from: https://examples.javacodegeeks.com/event-driven-data-management-for-microservices/

## Run RabbitMQ
```
docker run -d -e TZ=Asia/Seoul --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
```

## Run Spring Boot Produer
```
cd Event-driven-microservice-Producer
mvn spring-boot:run
```

## Use Postman to send POST request
* Event-driven-microservice-Producer/src/main/resources/Xyx_others.postman_collection.json
* send POST request to http://localhost:10091/student/create

## Run Spring Boot Consumer
```
cd Event-driven-microservice-Consumer
mvn spring-boot:run
```

## Status
* http://localhost:15672/
* guest / guest
