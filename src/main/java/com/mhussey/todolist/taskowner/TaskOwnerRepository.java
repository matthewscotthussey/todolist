package com.mhussey.todolist.taskowner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskOwnerRepository extends CrudRepository<TaskOwner, Long> {
}
