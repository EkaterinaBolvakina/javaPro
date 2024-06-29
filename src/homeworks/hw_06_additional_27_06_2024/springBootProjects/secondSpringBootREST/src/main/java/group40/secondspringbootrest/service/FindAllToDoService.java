package homeworks.hw_06_additional_27_06_2024.springBootProjects.secondSpringBootREST.src.main.java.group40.secondspringbootrest.service;

import group40.secondspringbootrest.dto.FindAllToDo;
import group40.secondspringbootrest.entity.ToDoEntity;
import group40.secondspringbootrest.repository.InterfaceToDoRepository;
import group40.secondspringbootrest.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
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
