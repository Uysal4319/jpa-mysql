package com.example.jpamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(path = "/") 
public class UserController {
	
	@Autowired	
	private UserRepository userRepository;
	
	@PostMapping(path = "/add") 
	public @ResponseBody
	String addNewUser(@RequestBody User user) {
		
		user.setCreationTime(new Date());
		userRepository.save(user);
		return "Saved";
	}
	
	@PostMapping(path = "/delete")
	public @ResponseBody
	String deleteUser(@RequestBody User user) {
		
		userRepository.delete(user);
		return "Deleted";
	}
	
	@PostMapping(path = "/update") // Map ONLY POST Requests
	public @ResponseBody
	String updateNewUser(@RequestBody User user) {
		
		userRepository.save(user);
		return "Updated";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
