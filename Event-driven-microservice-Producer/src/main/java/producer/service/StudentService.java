package producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import producer.model.EventType;
import producer.model.Student;
import producer.model.StudentEventDto;

@Service
public class StudentService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// Getting the rabbitMqTemplate object for sending the student object to the queue where a consumer
	// is listening and will process the student object further.
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Value("${student.create.queue}")
	String studentCreateQueue;

	public String createStudent(final Student student) {
		// Passing the student email to the queue where the designated consumer will listen to this event 
		// & process further (i.e. something like db processing and triggering an email etc.
		// We have omitted the other use-cases for simplicity.
		publishEventToRabbitMq(EventType.NEW_STUDENT_CONFIRMATION, student.getEmail());
		final String response = "[" + student.getEmail() + "] created successfully.";
		return response;
	}

	// @Async annotation ensures that the method is executed in a different background thread 
	// but not consume the main thread.
	@Async
	private void publishEventToRabbitMq(final EventType eventType, final String email) {
		final StudentEventDto eventDto = StudentEventDto.create(eventType, email);
		logger.info("Sending the following event object to the queue: " + eventDto);
		// Sending the new student object to the rabbitmq queue where a designated consumer will listen to the event
		// coming on this queue and process the further activities.
		rabbitTemplate.convertAndSend(studentCreateQueue, eventDto);
		logger.info("Message successfully sent to the rabbitMq.");
	}
}
