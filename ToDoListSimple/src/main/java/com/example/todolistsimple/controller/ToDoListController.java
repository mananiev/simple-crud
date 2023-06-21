package com.example.todolistsimple.controller;

import com.example.todolistsimple.entity.ToDoList;
import com.example.todolistsimple.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ToDoListController {

    private final ToDoListService toDoListService;

    @Autowired
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }


    @GetMapping("/home")
    public String home(Model model) {
        List<ToDoList> toDoList = toDoListService.toDoListActive(true);

        model.addAttribute("toDoList", toDoList);

        return "home";
    }

    @GetMapping("/taskform")
    public String taskForm(Model model) {
        ToDoList task = new ToDoList();

        model.addAttribute("task", task);
        return "taskform";
    }

    @PostMapping("taskform/save")
    public String saveTask(@ModelAttribute("task") ToDoList toDoList) {

        toDoListService.save(toDoList);

        return "redirect:/home";
    }

    @GetMapping("/taskformForUpdate")
    public String updateTask(@RequestParam("taskId") long taskId, Model model) {

        ToDoList task = toDoListService.findById(taskId);

        model.addAttribute("task", task);

        return "taskform";
    }


    @GetMapping("/delete")
    public String deleteTask(@RequestParam("taskId") long taskId) {

        toDoListService.deleteById(taskId);

        return "redirect:/home";
    }

    @GetMapping("/toArchive")
    public String archiveTask(@RequestParam("taskId") long taskId) {

        ToDoList task = toDoListService.findById(taskId);

        task.setStatus(false);

        toDoListService.save(task);

        return "redirect:/home";
    }

    @GetMapping("/archive")
    public String archive(Model model) {
        List<ToDoList> toDoList = toDoListService.toDoListActive(false);

        model.addAttribute("toDoList", toDoList);

        return "archive";
    }

    @GetMapping("/unarchive")
    public String unarchiveTask(@RequestParam("taskId") long taskId) {

        ToDoList task = toDoListService.findById(taskId);

        task.setStatus(true);

        toDoListService.save(task);

        return "redirect:/archive";
    }
}
