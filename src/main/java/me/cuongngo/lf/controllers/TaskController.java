package me.cuongngo.lf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.cuongngo.lf.models.Task;
import me.cuongngo.lf.msg.TaskMsg;
import me.cuongngo.lf.services.TaskService;
import me.cuongngo.lf.services.UserService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@Autowired UserService userService;
	
	@PostMapping
	public TaskMsg create(@RequestHeader("user-id") Long userId, TaskMsg message) {
		
		Task task = message.toModel(userId, userService);
		Task saved = taskService.save(task);
		
		return TaskMsg.fromModel(saved);
	}
	
	@GetMapping()
	public List<TaskMsg> getAll(@RequestHeader("user-id") Long userId) {
		return taskService.getAllTask(userId).stream().map(TaskMsg::fromModel).toList();
	}
}
