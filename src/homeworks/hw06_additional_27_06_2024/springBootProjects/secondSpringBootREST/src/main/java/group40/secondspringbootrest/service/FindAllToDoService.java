package group40.secondspringbootrest.service;

import group40.secondspringbootrest.dto.FindAllToDo;
import group40.secondspringbootrest.entity.ToDoEntity;
import group40.secondspringbootrest.repository.InterfaceToDoRepository;
import group40.secondspringbootrest.repository.ToDoRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class FindAllToDoService {

    private final InterfaceToDoRepository repository;

    public FindAllToDo findAll() {
        List<ToDoEntity> entities = repository.findAll();
        List<String> errors = new ArrayList<>();

        if (entities.isEmpty()) {
            errors.add("Our database is empty");
        }

        return new FindAllToDo(entities,errors);
    }
}
