package group40.secondspringbootrest.service;

import group40.secondspringbootrest.dto.AddToDoRequest;
import group40.secondspringbootrest.entity.ToDoEntity;
import group40.secondspringbootrest.repository.InterfaceToDoRepository;

public class AddToDoService {
    private InterfaceToDoRepository repository;

    public AddToDoService(InterfaceToDoRepository repository) {
        this.repository = repository;
    }

    public ToDoEntity addToDo(AddToDoRequest request) {
        System.out.println("Received request: " + request);
        var entityForAdd = convert(request);
        var createdEntity = repository.save(entityForAdd);
        System.out.println("Sending response: " + createdEntity);
        return createdEntity;
    }

    private ToDoEntity convert(AddToDoRequest request) {
        ToDoEntity newEntity = new ToDoEntity();
        newEntity.setTitle(request.getTitle());
        newEntity.setDescription(request.getDescription());
        return newEntity;
    }
}
