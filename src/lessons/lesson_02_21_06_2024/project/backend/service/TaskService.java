package lessons.lesson_02_21_06_2024.project.backend.service;

import lessons.lesson_02_21_06_2024.project.backend.dto.ClientResponseDto;
import lessons.lesson_02_21_06_2024.project.backend.dto.TaskDto;
import lessons.lesson_02_21_06_2024.project.backend.entity.Task;
import lessons.lesson_02_21_06_2024.project.backend.repositories.TaskRepositoryInterface;
import lessons.lesson_02_21_06_2024.project.backend.service.validation.ValidationRequest;

public class TaskService {
    private final TaskRepositoryInterface taskRepository;
    private final ValidationRequest validationRequest;

    public TaskService(TaskRepositoryInterface taskRepository, ValidationRequest validationRequest) {
        this.taskRepository = taskRepository;
        this.validationRequest = validationRequest;
    }


    public ClientResponseDto<String> addNewTask(TaskDto taskDto) {
        validationRequest.checkTaskName(taskDto);
        Task newTask = new Task(null, taskDto.getTaskNameDto(), taskDto.getTaskDescriptionDto(), false);
        taskRepository.add(newTask);
        if (newTask.getTaskId() > 0) {
            return new ClientResponseDto<>(200, newTask.getTaskName(),"Your task is created");
        } else {
            return new ClientResponseDto<>(250, newTask.getTaskName(),"");
        }
    }
}
