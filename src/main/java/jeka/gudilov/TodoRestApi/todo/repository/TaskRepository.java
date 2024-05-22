package jeka.gudilov.TodoRestApi.todo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import jeka.gudilov.TodoRestApi.todo.dto.TaskDto;
import jeka.gudilov.TodoRestApi.todo.model.Task;
import jeka.gudilov.TodoRestApi.todo.model.TaskStatus;

@Repository
public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    @PostConstruct
    private void init() {
        tasks.add(new Task(1, "New Task", "Do something", TaskStatus.NEW));
    }

    public List<Task> getAll() {
        return this.tasks;
    }

    public Optional<Task> getById(Integer id) {
        return tasks.stream().filter(t -> t.id().equals(id)).findFirst();
    }

    public Task create(TaskDto task) {
        Integer newId = tasks.size() + 1;
        Task newTask = new Task(newId, task.title(), task.task(), task.status());
        this.tasks.add(newTask);
        return newTask;
    }

    public Optional<Task> update(Integer id, TaskDto task) {
        Optional<Task> foundTask = this.getById(id);
        if (foundTask.isEmpty())
            return foundTask;
        Task rec = foundTask.get();
        Task updated = new Task(rec.id(), task.title(), task.task(), task.status());
        this.tasks.set(tasks.indexOf(rec), updated);
        return Optional.of(updated);
    }

    public void delete(Integer id) {
        this.tasks.removeIf(task -> task.id().equals(id));
    }

    public Optional<Task> updateStatus(Integer id, TaskStatus status) {
        Optional<Task> foundTask = this.getById(id);
        if (foundTask.isEmpty())
            return foundTask;
        Task rec = foundTask.get();
        Task updated = new Task(rec.id(), rec.title(), rec.task(), status);
        this.tasks.set(tasks.indexOf(rec), updated);
        return Optional.of(updated);
    }

}
