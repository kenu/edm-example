package producer.model;

// An enum to send the correct status of the event type.
public enum EventType {

	NEW_STUDENT_CONFIRMATION("NEW_STUDENT_CONFIRMATION"),
	UPDATE_STUDENT_CONFIRMATION("UPDATE_STUDENT_CONFIRMATION");

	public final String eventType;

	EventType(final String eventType) {
		this.eventType = eventType;
	}
}