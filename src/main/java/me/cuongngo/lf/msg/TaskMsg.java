package me.cuongngo.lf.msg;

import com.fasterxml.jackson.annotation.JsonProperty;

import me.cuongngo.lf.models.Task;

public class TaskMsg extends EntityMsg {
	
	@JsonProperty("name")
	private String name = "test";
	
	@JsonProperty("description")
	private String description = "abc";
	
	@JsonProperty("estimation")
	private int estimation = 1;

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
	
	public Task toModel(Long userID) {
		Task model = new Task();
		
		model.setId(this.id);
		model.setCreatedBy(this.createdBy);
		model.setCreatedBy(this.createdBy != null ? this.createdBy : userID);
		model.setUpdatedBy(userID);
		
		return model;
	}
}
