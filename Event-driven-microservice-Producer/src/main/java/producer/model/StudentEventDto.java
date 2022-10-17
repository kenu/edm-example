package producer.model;

// Class object which is sent to the queue.
public class StudentEventDto {

	public EventType type;
	public String email;

	public StudentEventDto(final EventType type, final String email) {
		this.type = type;
		this.email = email;
	}

	public EventType getType() {
		return type;
	}

	public String getEmail() {
		return email;
	}

	public static StudentEventDto create(final EventType eventType, final String email) {
		return new StudentEventDto(eventType, email);
	}

	@Override
	public String toString() {
		return "StudentEventDto [type=" + type + ", email=" + email + "]";
	}
}
