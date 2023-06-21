package com.example.todolistsimple.service;

import com.example.todolistsimple.entity.ToDoList;
import com.example.todolistsimple.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListServiceImpl implements ToDoListService{

    private final ToDoListRepository toDoListRepository;


    @Autowired
    public ToDoListServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public List<ToDoList> toDoList() {
        return toDoListRepository.findAll();
    }

    @Override
    public void save(ToDoList toDoList) {
        toDoListRepository.save(toDoList);
    }

    @Override
    public ToDoList findById(long taskId) {
        Optional<ToDoList> optional = toDoListRepository.findById(taskId);
        ToDoList toDoList = null;


        if (optional.isPresent()) {
            toDoList=optional.get();
        } else {
            throw new RuntimeException("Did not find toDoList");
        }

        return toDoList;
    }

    @Override
    public void deleteById(long taskId) {
        toDoListRepository.deleteById(taskId);
    }

    @Override
    public List<ToDoList> toDoListActive(boolean status) {
        return toDoListRepository.findAllByStatus(status);
    }


}
