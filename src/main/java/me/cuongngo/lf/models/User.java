package me.cuongngo.lf.models;

import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "users", schema = "be")
public class User extends Entity {
	
	private String name;
	
	private Role role;
}
