package com.mhussey.todolist.task;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TaskRepository extends ListCrudRepository<Task, Long>, PagingAndSortingRepository<Task, Long> {

    public List<Task> findByDueDtBefore(Instant duDtBefore);

    public List<Task> findByCompletedIs(boolean completed);

    public List<Task> findAllByOrderByPriorityDesc();

    public List<Task> findTaskByDueDtBeforeAndCompletedIsOrderByPriorityDesc(Instant dueDtBefore, boolean completed);
}
