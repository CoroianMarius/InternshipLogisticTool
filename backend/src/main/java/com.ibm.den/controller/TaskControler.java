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

    @PostMapping("/{ActivityName}")
    //Creates a new task. Remember to send the activity name in the path
    public TaskDto createTask(@RequestBody TaskDto task, @PathVariable String ActivityName) {
        return taskService.createTask(task, ActivityName);
    }

    @PostMapping("/assignTask/{taskName}")
    //Assigns a task to a list of students. Remember to send the task name in the path
    public void assignTask(@RequestBody ArrayList<String> studentEmails, @PathVariable String taskName) {
        taskService.assignTask(studentEmails, taskName);
    }


}
