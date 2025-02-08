package com.mhussey.todolist.task;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController( final TaskRepository taskRepository ) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks(@RequestParam Optional<Boolean> completed) {
        //todo: look in to using multiple optional request parameters to filter queries without bloating repository interface *Specification?
        if (completed.isPresent()) {
            return taskRepository.findByCompletedIs(completed.get());
        }
        else return taskRepository.findAllByOrderByPriorityDesc();

    }

    @GetMapping("/getTasksDueBy")
    public List<Task> getTasksDueBy(@RequestParam Instant dueDate) {
        return taskRepository.findTaskByDueDtBeforeAndCompletedIsOrderByPriorityDesc(dueDate, false);
    }

    @GetMapping("/getTaskById/{id}")
    public Task getTaskById(@PathVariable long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/updateTask/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task updateTask) {
        //uses the findById method from the CRUD interface to get a Task matching the id, if no match is found we return nothing.
        Optional<Task> tempTask = taskRepository.findById(id);
        if (tempTask.isPresent()) {
            tempTask.get().setName(updateTask.getName());
            return taskRepository.save(tempTask.get());
        } else{
            return null;
            //todo: this should probably throw an exception or something.
            //      I'm not thrilled with returning null but better than a 500 error.
            //      404 would be great if we were using HTTPResponse
        }
    }

    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        try {
            taskRepository.deleteById(id);
        }
        catch(NullPointerException e) {
            return "Delete Task Failed";
        }
        return "Deleted Task Successfully";
    }
}
