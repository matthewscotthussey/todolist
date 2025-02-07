package com.mhussey.todolist;

import com.mhussey.todolist.taskowner.TaskOwnerController;
import com.mhussey.todolist.taskowner.TaskOwnerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

}
