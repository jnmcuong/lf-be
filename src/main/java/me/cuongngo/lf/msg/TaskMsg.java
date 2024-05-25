package me.cuongngo.lf.msg;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import me.cuongngo.lf.models.Task;
import me.cuongngo.lf.models.User;
import me.cuongngo.lf.services.UserService;

public class TaskMsg extends EntityMsg {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("estimation")
	private int estimation;
	
	@JsonProperty("assignee")
	private Long assignee;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEstimation() {
		return estimation;
	}

	public void setEstimation(int estimation) {
		this.estimation = estimation;
	}
	
	public Task toModel(Long userID, UserService userService) {
		Task model = new Task();
		
		model.setId(this.id);
		model.setCreatedAt(this.createdAt);
		model.setCreatedBy(this.createdBy != null ? this.createdBy : userID);
		model.setUpdatedBy(userID);
		model.setVersion(this.version != null ? this.version : 0);
		
		model.setName(this.name);
		model.setDescription(this.description);
		model.setEstimation(this.estimation);
		
		Optional<User> userOpt = assignee != null ? userService.findById(assignee) : Optional.empty();
		if (userOpt.isPresent()) {
			model.setAssignee(userOpt.get());
		}
		
		return model;
	}
	
	public static TaskMsg fromModel(Task model) {
		TaskMsg msg = new TaskMsg();
		
		msg.id = model.getId();
		msg.version = model.getVersion();
		msg.createdAt = model.getCreatedAt();
		msg.createdBy = model.getCreatedBy();
		msg.updatedAt = model.getUpdatedAt();
		msg.updatedBy = model.getUpdatedBy();
		msg.name = model.getName();
		msg.description = model.getDescription();
		msg.estimation = model.getEstimation();
		
		return msg;
	}
}
