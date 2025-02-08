package com.mhussey.todolist.task;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.Instant;

@Table("TASK")
public
class Task {
    @Id
    private long id;

    private long categoryId;
    private long ownerId;
    private String name;
    private String description;
    private long priority;
    private Instant createDt;
    private Instant dueDt;
    private boolean completed;

    public Task(long categoryId, long ownerId, String name, String description, long priority, Instant dueDt, boolean completed) {
        this.categoryId = categoryId;
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.createDt = Instant.now();
        this.dueDt = dueDt;
        this.completed = completed;
    }

    //get
    public long getId() {
        return id;
    }
    public long getCategoryId() {return categoryId;}
    public long getOwnerId() {return ownerId;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public long getPriority() {return priority;}
    public Instant getCreateDt() {return createDt;}
    public Instant getDueDt() {return dueDt;}
    public boolean isCompleted() {return completed;}

    //set
    public void setId(long id) {
        this.id = id;
    }
    public void setCategoryId(long categoryId) {this.categoryId = categoryId;}
    public void setOwnerId(long ownerId) {this.ownerId = ownerId;}
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {this.description = description;}
    public void setPriority(long priority) {this.priority = priority;}
    public void setCreateDt(Instant createDt) {this.createDt = createDt;}
    public void setDueDt(Instant dueDt) {this.dueDt = dueDt;}
    public void setCompleted(boolean completed) {this.completed = completed;}
}
