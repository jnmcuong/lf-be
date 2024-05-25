package me.cuongngo.lf.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.cuongngo.lf.models.User;
import me.cuongngo.lf.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository userRepository;
	
	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
}
