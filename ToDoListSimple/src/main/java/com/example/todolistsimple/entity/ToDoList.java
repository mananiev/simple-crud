package com.example.todolistsimple.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "to_do_list")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Boolean status = true;

    public ToDoList() {
    }

    public ToDoList(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public ToDoList(long id, String title, String description, boolean status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public ToDoList(String title, String description, boolean status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public ToDoList setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ToDoList setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToDoList setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public ToDoList setStatus(boolean status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
