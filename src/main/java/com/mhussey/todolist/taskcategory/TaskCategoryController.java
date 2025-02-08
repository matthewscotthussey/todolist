package com.mhussey.todolist.taskcategory;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TaskCategories")
public class TaskCategoryController {
    private final TaskCategoryRepository taskCategoryRepository;

    public TaskCategoryController( final TaskCategoryRepository taskCategoryRepository ) {
        this.taskCategoryRepository = taskCategoryRepository;
    }

    @PostMapping("/addTaskCategory")
    public TaskCategory addTaskCategory(@RequestBody TaskCategory taskCategory) {
        return taskCategoryRepository.save(taskCategory);
    }

    @GetMapping("/getAllTaskCategories")
    public List<TaskCategory> getAllTaskCategories() {
        return taskCategoryRepository.findAll();
    }

    @GetMapping("/getTaskCategoryById/{id}")
    public TaskCategory getTaskCategoryById(@PathVariable long id) {
        return taskCategoryRepository.findById(id).orElse(null);
    }

    @PutMapping("/updateTaskCategory/{id}")
    public TaskCategory updateTaskCategory(@PathVariable long id, @RequestBody TaskCategory updateTaskCategory) {
        //uses the findById method from the CRUD interface to get a TaskCategory matching the id, if no match is found we return nothing.
        Optional<TaskCategory> tempTaskCategory = taskCategoryRepository.findById(id);
        if (tempTaskCategory.isPresent()) {
            tempTaskCategory.get().setName(updateTaskCategory.getName());
            tempTaskCategory.get().setPriority(updateTaskCategory.getPriority());
            return taskCategoryRepository.save(tempTaskCategory.get());
        } else{
            return null;
            //todo: this should probably throw an exception or something.
            //      I'm not thrilled with returning null but better than a 500 error.
            //      404 would be great if we were using HTTPResponse
        }
    }

    //NOTE: ON DELETE CASCADE is set on the FK for ID on the TASK table.
    // This means deleting a category will delete all associated tasks from the TASK table.
    @DeleteMapping("/deleteTaskCategory/{id}")
    public String deleteTaskCategory(@PathVariable Long id) {
        try {
            taskCategoryRepository.deleteById(id);
        }
        catch(NullPointerException e) {
            return "Delete TaskCategory Failed";
        }
        return "Deleted TaskCategory Successfully";
    }

}
