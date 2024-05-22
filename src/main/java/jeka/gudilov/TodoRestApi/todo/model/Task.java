package jeka.gudilov.TodoRestApi.todo.model;

public record Task(
                Integer id,
                String title,
                String task,
                TaskStatus status) {
}
