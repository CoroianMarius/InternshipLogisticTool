package com.ibm.den.Services;

import com.ibm.den.Classes.Task;
import org.springframework.stereotype.Service;
import com.ibm.den.Repository.TaskRepository;
import java.util.ArrayList;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ArrayList<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        Task currentTask = taskRepository.save(task);
        return currentTask;
    }

    public Task updateTask(Long id, Task task) {
        Task currentTask = taskRepository.findById(id).orElse(null);
        currentTask.setDescription(task.getDescription());
        currentTask.setStudent(task.getStudent());
        return taskRepository.save(currentTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
