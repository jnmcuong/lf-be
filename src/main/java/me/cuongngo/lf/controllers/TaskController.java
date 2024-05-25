package me.cuongngo.lf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.cuongngo.lf.models.Role;
import me.cuongngo.lf.msg.TaskMsg;
import me.cuongngo.lf.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@PostMapping
	public TaskMsg create(@RequestHeader("user-id") long userID, TaskMsg message) {
		
		
		return null;
	}
	
	@GetMapping(value = "/{id}")
	public TaskMsg get(@RequestHeader("user-id") long userID, @PathVariable("id") long id) {
		
		System.out.println(userID);
		
		/*
		 * deserialize token 
		 */
//		String userID = token; //temporarily
		
		Iterable<Role> roles = taskService.getAllRole();
		roles.forEach(r -> {
			System.out.println(r.getName());
		});
		
		
		return new TaskMsg();
	}
	
	@GetMapping()
	public List<TaskMsg> getAll() {
		return List.of(new TaskMsg());		
	}
}
