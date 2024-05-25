package me.cuongngo.lf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.cuongngo.lf.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
