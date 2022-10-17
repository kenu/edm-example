package consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Enable rabbit listener endpoints.
@EnableRabbit
public class EventDrivenMicroserviceConsumer {

	private static Logger logger = LoggerFactory.getLogger(EventDrivenMicroserviceConsumer.class);

	public static void main(String[] args) {
		SpringApplication.run(EventDrivenMicroserviceConsumer.class, args);
		logger.info("Event driven microservice consumer application started successfully.");
	}
}
