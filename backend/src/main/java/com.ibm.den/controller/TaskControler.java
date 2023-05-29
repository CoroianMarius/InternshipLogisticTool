package com.ibm.den.controller;

import com.ibm.den.dto.TaskDto;
import com.ibm.den.entities.Task;
import com.ibm.den.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/task")
public class TaskControler {

    TaskService taskService;

    TaskControler(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ArrayList<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/{ActivityName}")
    public TaskDto createTask(@RequestBody TaskDto task, @PathVariable String ActivityName) {
        return taskService.createTask(task, ActivityName);
    }

    @PostMapping("assignTask/{taskName}")
    public void assignTask(@RequestBody ArrayList<String> studentEmails, @PathVariable String taskName) {
        taskService.assignTask(studentEmails, taskName);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }



}
