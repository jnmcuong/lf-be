package me.cuongngo.lf.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.cuongngo.lf.models.Task;
import me.cuongngo.lf.models.User;
import me.cuongngo.lf.repositories.TaskRepository;
import me.cuongngo.lf.repositories.UserRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Task> getAllTask(Long userId) {
		Iterable<Task> tasks = taskRepository.findAll();
		Optional<User> userOpt = userRepository.findById(userId);
		
		return StreamSupport.stream(tasks.spliterator(), false).filter(t -> {
			
			if (CollectionUtils.isEmpty(t.getPermissions())) {
				return true;
			}
			
			return ListUtils.emptyIfNull(t.getPermissions()).stream().anyMatch(p -> {
				if (Objects.equals(p.getUser().getId(), userId) && p.isRead())
					return true;
				
				if (userOpt.isPresent() && p.getRole() != null && userOpt.get().getRoles().contains(p.getRole())) {
					return true;
				}
				
				return false;
			});
		}).toList();
	}
	
	@Override
	public Task save(Task model) {
		return taskRepository.save(model);
	}
	
	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}
}
