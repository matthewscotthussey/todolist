package com.mhussey.todolist.taskcategory;

import com.mhussey.todolist.task.Task;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskCategoryRepository extends ListCrudRepository<TaskCategory, Long> {

    public List<TaskCategory> findByNameIgnoreCaseOrderByPriorityDesc(String name);

}
