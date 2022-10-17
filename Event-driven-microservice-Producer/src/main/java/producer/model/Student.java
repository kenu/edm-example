package producer.model;

// Simple pojo class that will be used in the post request.
public class Student {

	public final int id;
	public final String name;
	public final int age;
	public final String dateOfBith;
	public final String email;

	public Student(final int id, final String name, final int age, 
			final String dateOfBith, final String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateOfBith = dateOfBith;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDateOfBith() {
		return dateOfBith;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", dateOfBith=" + dateOfBith + ", email="
				+ email + "]";
	}
}