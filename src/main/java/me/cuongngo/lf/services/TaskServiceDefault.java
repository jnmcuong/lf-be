package me.cuongngo.lf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.cuongngo.lf.models.Role;
import me.cuongngo.lf.repositories.RoleRepository;

@Service
public class TaskServiceDefault implements TaskService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Iterable<Role> getAllRole() {
		return roleRepository.findAll();
	}
}
