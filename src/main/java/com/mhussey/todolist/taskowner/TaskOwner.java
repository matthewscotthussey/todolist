package com.mhussey.todolist.taskowner;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("TASK_OWNER")
public
class TaskOwner {
    @Id
    private long id;

    private String name;

    public TaskOwner(String name) {
        this.name = name;
    }

    //get
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    //set
    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
