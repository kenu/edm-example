package producer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Required to declare an exchange, a queue, and a message converter on application startup.
@Configuration
public class RabbitMqConfigForProducer {

	@Value("${student.create.queue}")
	String studentCreateQueue;
	
	@Bean
	Queue queue() {
		return new Queue(studentCreateQueue);
	}

	@Bean
	Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
