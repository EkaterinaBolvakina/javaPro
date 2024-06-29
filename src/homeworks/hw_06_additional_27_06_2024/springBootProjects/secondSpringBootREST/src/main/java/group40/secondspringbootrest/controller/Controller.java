package homeworks.hw_06_additional_27_06_2024.springBootProjects.secondSpringBootREST.src.main.java.group40.secondspringbootrest.controller;

import group40.secondspringbootrest.dto.AddToDoRequest;
import group40.secondspringbootrest.dto.FindAllToDo;
import group40.secondspringbootrest.entity.ToDoEntity;
import group40.secondspringbootrest.service.AddToDoService;
import group40.secondspringbootrest.service.FindAllToDoService;
import group40.secondspringbootrest.service.FindToDoByIdService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/todos")
public class Controller {
    private final AddToDoService addToDoService;
    private final FindAllToDoService findAllToDoService;
    private final FindToDoByIdService findToDoByIdService;


    public Controller(AddToDoService addToDoService, FindAllToDoService findAllToDoService, FindToDoByIdService findToDoByIdService) {
        this.addToDoService = addToDoService;
        this.findAllToDoService = findAllToDoService;
        this.findToDoByIdService = findToDoByIdService;
    }

    @PostMapping
    public ToDoEntity addToDo(@RequestBody AddToDoRequest request) {return addToDoService.addToDo(request);}

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public FindAllToDo findAll(){
        FindAllToDo response = findAllToDoService.findAll();
        System.out.println(response);
        return response;
    }

    @GetMapping("/{idPath}")
    public ToDoEntity findToDoById(@PathVariable("idPath") Integer id){
        return findToDoByIdService.findById(id);
    }

}
