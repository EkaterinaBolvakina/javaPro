package lessons.lesson_02_21_06_2024.project.backend.service;

import lessons.lesson_02_21_06_2024.project.backend.dto.ClientResponseDto;
import lessons.lesson_02_21_06_2024.project.backend.dto.TaskDto;
import lessons.lesson_02_21_06_2024.project.backend.entity.Task;
import lessons.lesson_02_21_06_2024.project.backend.repositories.TaskRepositoryInterface;
import lessons.lesson_02_21_06_2024.project.backend.service.validation.ValidationRequest;

import java.util.List;

public class TaskService {
    private final TaskRepositoryInterface taskRepository;
    private final ValidationRequest validationRequest;

    public TaskService(TaskRepositoryInterface taskRepository, ValidationRequest validationRequest) {
        this.taskRepository = taskRepository;
        this.validationRequest = validationRequest;
    }

    public ClientResponseDto<Task> addNewTask(TaskDto taskDto) {
        System.out.println("Received request: " + taskDto);

        List<String> errors = validationRequest.checkTask(taskDto);

        if (errors.isEmpty()) {
            Task newTaskForAdd = new Task(null, taskDto.getTaskNameDto(), taskDto.getTaskDescriptionDto(), false);
            Task savedTask = taskRepository.add(newTaskForAdd);
            return new ClientResponseDto<>(200, savedTask, errors);
        } else {
            return new ClientResponseDto<>(400, new Task(), errors);
        }
    }
}
