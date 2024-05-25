package me.cuongngo.lf.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "users", schema = "be")
public class User extends Entity {
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
        name = "User_Role", 
        joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, 
        inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }
    )
	private List<Role> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
