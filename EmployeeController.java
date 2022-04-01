package com.workmotion.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workmotion.model.Employee;
import com.workmotion.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/user")
public class EmployeeController extends EmployeeRepository{

	private final static Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

	@GetMapping("/save") 
    public ResponseEntity<Employee> saveUser(@RequestBody Employee employee) { 
		//@PostMapping
		try{ 
		 Employee emp = saveEmployee(employee);
		 LOGGER.info("Employee saved " + emp.getName());
		 
		} catch (Exception ex) {
			 LOGGER.log(Level.SEVERE, "Error in saveUser - " + ex.getMessage()); 
	    }
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
	
	/*@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	@GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) {
		 Optional<User> user = userRepository.findById(id);

		    if(user.isPresent()) {
		        return ResponseEntity.ok().body(user.get());
		    } else {
		        return ResponseEntity.notFound().build();
		    }
    }
	
	@Autowired
    private UserRepository userRepository;
        
	@GetMapping
	public List<User> findAllUsers() {
	    return userRepository.findAll();
	}
	*/
	
}
