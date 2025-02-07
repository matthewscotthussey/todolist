package com.mhussey.todolist.taskowner;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TaskOwners")
public class TaskOwnerController {
    private final TaskOwnerRepository taskOwnerRepository;

    public TaskOwnerController( final TaskOwnerRepository taskOwnerRepository ) {
        this.taskOwnerRepository = taskOwnerRepository;
    }

    @PostMapping("/addTaskOwner")
    public TaskOwner addTaskOwner(@RequestBody TaskOwner taskOwner) {
        return taskOwnerRepository.save(taskOwner);
    }

    @GetMapping("/getAllTaskOwners")
    public List<TaskOwner> getAllTaskOwners() {
        return (List<TaskOwner>) taskOwnerRepository.findAll();
    }

    @GetMapping("/getTaskOwnerById/{id}")
    public TaskOwner getTaskOwnerById(@PathVariable long id) {
        return taskOwnerRepository.findById(id).get();
    }

    @PutMapping("/updateTaskOwner/{id}")
    public TaskOwner updateTaskOwner(@PathVariable long id, @RequestBody TaskOwner updateTaskOwner) {
        //uses the findById method from the CRUD interface to get a TaskOwner matching the id, if no match is found we return nothing.
        Optional<TaskOwner> tempTaskOwner = taskOwnerRepository.findById(id);
        if (tempTaskOwner.isPresent()) {
            tempTaskOwner.get().setName(updateTaskOwner.getName());
            return taskOwnerRepository.save(tempTaskOwner.get());
        } else{
            return null;
            //todo: this should probably throw an exception or something.
            //      I'm not thrilled with returning null but better than a 500 error.
            //      404 would be great if we were using HTTPResponse
        }
    }

    @DeleteMapping("/deleteTaskOwner/{id}")
    public String deleteTaskOwner(@PathVariable Long id) {
        try {
            taskOwnerRepository.deleteById(id);
        }
        catch(NullPointerException e) {
            return "Delete TaskOwner Failed";
        }
        return "Deleted TaskOwner Successfully";
    }

}
