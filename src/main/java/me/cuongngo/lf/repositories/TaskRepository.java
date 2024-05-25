package me.cuongngo.lf.repositories;

import org.springframework.data.repository.CrudRepository;

import me.cuongngo.lf.models.Task;

@org.springframework.stereotype.Repository
public interface TaskRepository extends CrudRepository<Task, Long>{

}
