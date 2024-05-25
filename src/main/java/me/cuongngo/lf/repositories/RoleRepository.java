package me.cuongngo.lf.repositories;

import org.springframework.data.repository.CrudRepository;

import me.cuongngo.lf.models.Role;

@org.springframework.stereotype.Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
