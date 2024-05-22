package jeka.gudilov.TodoRestApi.todo.dto;

import jeka.gudilov.TodoRestApi.todo.model.TaskStatus;

public record StatusDto(
    TaskStatus status
) {
    
}
