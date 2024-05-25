package me.cuongngo.lf.services;

import java.util.List;

import me.cuongngo.lf.models.Task;

public interface TaskService {

	List<Task> getAllTask(Long userId);

	Task save(Task model);
}
