package group40.secondspringbootrest.repository;

import group40.secondspringbootrest.entity.ToDoEntity;

import java.util.List;
import java.util.Optional;

public interface InterfaceToDoRepository {

    ToDoEntity save(ToDoEntity toDoEntity);
    List<ToDoEntity> findAll();
    Optional<ToDoEntity> findById(Integer id);
}
