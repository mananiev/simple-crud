package com.example.todolistsimple.service;

import com.example.todolistsimple.entity.ToDoList;

import java.util.List;

public interface ToDoListService {
    List<ToDoList> toDoList();

    void save(ToDoList toDoList);

    ToDoList findById(long taskId);

    void deleteById(long taskId);

    List<ToDoList> toDoListActive(boolean status);
}
