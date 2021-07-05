package com.example.todolistdemo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "todoItem")
public class TodoItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "priority")
    private String priority;
    @Column(name = "description")
    private Long description;
    @Column(name = "date")
    private Date date = new Date();
    @Column(name = "done")
    private boolean done = false;

    public TodoItem(){

    }

    public TodoItem(String name, String priority, Long description) {
        this.name = name;
        this.priority = priority;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", description=" + description +
                ", date=" + date +
                ", done=" + done +
                '}';
    }
}
