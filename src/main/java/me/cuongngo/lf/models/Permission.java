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
}
