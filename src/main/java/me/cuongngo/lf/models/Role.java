package me.cuongngo.lf.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@jakarta.persistence.Entity
@Table(name = "roles", schema = "be")
public class Role extends Entity {
	
	@Column(name = "name")
	private String name;
	
	@Transient
	private List<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
