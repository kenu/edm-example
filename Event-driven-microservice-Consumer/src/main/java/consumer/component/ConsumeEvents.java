package consumer.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import consumer.model.StudentEventDto;

// Service class that will consume the message from the given queue as soon as they are published/pushed to the queue.
@Service
public class ConsumeEvents {

	// Annotation allows the message to be listened at the given queue.
	// Queue name is directly read from the properties file.
	@RabbitListener(queues = "${student.create.queue}")
	public void recievedMessage(final StudentEventDto studentEventDto) {
		System.out.println("Received following message from rabbitmq= " + studentEventDto);
		
		// Here once the message by the consumer application, we can add the same to the database of persistence.
		// This code is not yet implemented for simplicity.
	}
}
