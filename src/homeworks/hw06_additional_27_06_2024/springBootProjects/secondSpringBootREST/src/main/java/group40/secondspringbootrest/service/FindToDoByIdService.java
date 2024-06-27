package group40.secondspringbootrest.service;

import group40.secondspringbootrest.entity.ToDoEntity;
import group40.secondspringbootrest.repository.InterfaceToDoRepository;
import group40.secondspringbootrest.repository.ToDoRepository;

import java.util.Optional;

public class FindToDoByIdService {

    private final InterfaceToDoRepository repository;

    public FindToDoByIdService(InterfaceToDoRepository repository) {
        this.repository = repository;
    }

    public ToDoEntity findById(Integer id){
        Optional<ToDoEntity> optionalToDoEntity = repository.findById(id);

        if (optionalToDoEntity.isPresent()){
            return optionalToDoEntity.get();
        } else {
            throw new IllegalStateException("Entity with id = " + id + " not found!");
        }
    }
}
