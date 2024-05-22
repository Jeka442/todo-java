package jeka.gudilov.TodoRestApi.todo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jeka.gudilov.TodoRestApi.todo.dto.StatusDto;
import jeka.gudilov.TodoRestApi.todo.dto.TaskDto;
import jeka.gudilov.TodoRestApi.todo.model.Task;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import jeka.gudilov.TodoRestApi.todo.service.TaskService;

@RestController()
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public List<Task> getAll() {
        return this.taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable Integer id) {
        return this.taskService.getById(id);
    }

    @PostMapping("")
    public Task create(@RequestBody TaskDto task) {
        return this.taskService.create(task);
    }

    @PostMapping("/status/{id}")
    public Task postMethodName(@PathVariable Integer id, @RequestBody StatusDto status) {
        return this.taskService.updateStatus(id, status.status());
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Integer id, @RequestBody TaskDto task) {
        return this.taskService.update(id, task);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.taskService.delete(id);
    }

}
