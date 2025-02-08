package com.mhussey.todolist.taskcategory;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("TASK_CATEGORY")
public
class TaskCategory {
    @Id
    private long id;

    private String name;
    private long priority;

    public TaskCategory(String name, long priority) {
        this.name = name;
        this.priority = priority;
    }

    //get
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPriority() {return priority;}
    //set
    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPriority(long priority) {this.priority = priority;}
}
