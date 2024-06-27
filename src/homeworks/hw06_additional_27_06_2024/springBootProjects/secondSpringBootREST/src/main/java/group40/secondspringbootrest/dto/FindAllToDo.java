package group40.secondspringbootrest.dto;

import group40.secondspringbootrest.entity.ToDoEntity;

import java.util.List;

public class FindAllToDo {
    private List<ToDoEntity> entities;
    private List<String> errorMessages;

    public FindAllToDo(List<ToDoEntity> entities, List<String> errorMessages) {
        this.entities = entities;
        this.errorMessages = errorMessages;
    }

    @Override
    public String toString() {
        return "FindAllToDo{" +
                "entities=" + entities +
                ", errorMessages=" + errorMessages +
                '}';
    }
}
