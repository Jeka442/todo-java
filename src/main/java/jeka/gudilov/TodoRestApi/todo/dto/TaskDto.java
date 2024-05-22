package jeka.gudilov.TodoRestApi.todo.dto;

import jeka.gudilov.TodoRestApi.todo.model.TaskStatus;

public record TaskDto(
        String title,
        String task,
        TaskStatus status) {

}
