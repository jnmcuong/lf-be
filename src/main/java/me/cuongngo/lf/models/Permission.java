package me.cuongngo.lf.models;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@jakarta.persistence.Entity
@Table(name = "permissions", schema = "be")
public class Permission extends Entity {
	
	@Transient
	private Task task;
	
	@Transient
	private User user;
	
	@Transient
	private Role role;
	
	@Column(name = "read")
	private boolean read;
	
	@Column(name = "update")
	private boolean update;
	
	@Column(name = "delete")
	private boolean delete;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	
}
