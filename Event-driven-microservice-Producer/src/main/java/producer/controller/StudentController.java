package producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import producer.model.Student;
import producer.service.StudentService;

//Useful to create the RESTful webservices.
@RestController
@RequestMapping(value= "/student")
public class StudentController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	StudentService studentService;

	// Saves the student entity.
	// @PostMapping annotation handles the http post request matched with the given uri.
	// @RequestBody annotation binds the http request body to the domain object.
	@PostMapping(value= "/create")
	public ResponseEntity<String> createNewStudent(@RequestBody final Student student) {
		logger.info("Creating a new student= " + student.toString());
		final String response = studentService.createStudent(student);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}