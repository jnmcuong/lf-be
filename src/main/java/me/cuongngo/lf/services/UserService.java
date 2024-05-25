package me.cuongngo.lf.services;

import java.util.Optional;

import me.cuongngo.lf.models.User;

public interface UserService {

	Optional<User> findById(Long id);

}
