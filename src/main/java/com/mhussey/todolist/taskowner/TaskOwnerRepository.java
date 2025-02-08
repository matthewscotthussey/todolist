package com.mhussey.todolist.taskowner;

import com.mhussey.todolist.task.Task;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskOwnerRepository extends ListCrudRepository<TaskOwner, Long> {

    public List<TaskOwner> findByNameIgnoreCase(String name);
}
