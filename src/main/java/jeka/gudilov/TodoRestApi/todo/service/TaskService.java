package jeka.gudilov.TodoRestApi.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jeka.gudilov.TodoRestApi.exception.BadRequestException;
import jeka.gudilov.TodoRestApi.exception.NotFoundException;
import jeka.gudilov.TodoRestApi.todo.dto.TaskDto;
import jeka.gudilov.TodoRestApi.todo.model.Task;
import jeka.gudilov.TodoRestApi.todo.model.TaskStatus;
import jeka.gudilov.TodoRestApi.todo.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository _task;

    public TaskService(TaskRepository taskRepo) {
        this._task = taskRepo;
    }

    public List<Task> getAll() {
        return this._task.getAll();
    }

    public Task getById(Integer id) {
        Optional<Task> result = this._task.getById(id);
        if (result.isEmpty())
            throw new NotFoundException("Task not found by the id");
        return result.get();
    }

    public Task create(TaskDto task) {
        return this._task.create(task);
    }

    public Task update(Integer id, TaskDto task) {
        Optional<Task> result = this._task.update(id, task);
        if (result.isEmpty())
            throw new BadRequestException("task not found");
        return result.get();
    }

    public void delete(Integer id) {
        this._task.delete(id);
    }

    public Task updateStatus(Integer id, TaskStatus status) {
        Optional<Task> result = this._task.updateStatus(id, status);
        if (result.isEmpty())
            throw new BadRequestException("task not found");
        return result.get();
    }
}
