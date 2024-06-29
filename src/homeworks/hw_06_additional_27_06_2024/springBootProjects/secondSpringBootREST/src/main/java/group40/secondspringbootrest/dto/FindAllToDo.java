package homeworks.hw_06_additional_27_06_2024.springBootProjects.secondSpringBootREST.src.main.java.group40.secondspringbootrest.dto;

import group40.secondspringbootrest.entity.ToDoEntity;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
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
