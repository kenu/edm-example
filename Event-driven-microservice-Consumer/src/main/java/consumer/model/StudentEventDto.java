package consumer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// Class object from which the event type are retrieved from the queue.
public class StudentEventDto {

	public EventType type;
	public String email;

	// Required for deserialization purpose.
	@JsonCreator
	public StudentEventDto(@JsonProperty("type") final EventType type, 
			@JsonProperty("email") final String email) {
		this.type = type;
		this.email = email;
	}

	public EventType getType() {
		return type;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "StudentEventDto [type=" + type + ", email=" + email + "]";
	}
}
