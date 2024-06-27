package group40.secondspringbootrest.repository;

import group40.secondspringbootrest.entity.ToDoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToDoRepository implements InterfaceToDoRepository{
    private Integer idCounter = 1;
    private List<ToDoEntity> database = new ArrayList<>();

    @Override
    public ToDoEntity save(ToDoEntity toDoEntity) {
        if(toDoEntity.getId() != null){
            return update(toDoEntity);
        } else {
            toDoEntity.setId(idCounter++);
            database.add(toDoEntity);
            return toDoEntity;
        }
    }

    private ToDoEntity update(ToDoEntity toDoEntity){
        for(int i = 0; i < database.size(); i++){
            if(database.get(i).getId().equals(toDoEntity.getId())){
                database.set(i, toDoEntity);
                return toDoEntity;
            }
        }
        throw new IllegalStateException("Failed to update!");
    }

    @Override
    public List<ToDoEntity> findAll() {
        return database;
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        return database.stream()
                .filter(toDoEntity -> toDoEntity.getId().equals(id))
                .findFirst();
    }
}
