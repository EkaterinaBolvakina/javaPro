package lessons.lesson_02_21_06_2024.project.backend.service;

import lessons.lesson_02_21_06_2024.project.backend.dto.ClientResponseDto;
import lessons.lesson_02_21_06_2024.project.backend.dto.TaskDto;
import lessons.lesson_02_21_06_2024.project.backend.entity.Task;
import lessons.lesson_02_21_06_2024.project.backend.repositories.TaskRepositoryInterface;
import lessons.lesson_02_21_06_2024.project.backend.service.validation.ValidationRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
            Task newTaskForAdd = new Task(0, taskDto.getTaskNameDto(), taskDto.getTaskDescriptionDto(), false);
            Task savedTask = taskRepository.add(newTaskForAdd);
            return new ClientResponseDto<>(200, savedTask, errors);
        } else {
            return new ClientResponseDto<>(400, null, errors);
        }
    }

    public ClientResponseDto<Task> findTaskById(Integer taskId) {
        TaskDto taskDto = new TaskDto("SampleName", "SampleDescription");
        List<String> errors = validationRequest.checkTask(taskDto);

        if (!errors.isEmpty()) {
            return new ClientResponseDto<>(400, null, errors);
        }
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task foundedTask = optionalTask.get();
            return new ClientResponseDto<>(200, foundedTask, errors);
        } else {
            errors.add("Task not found with ID: " + taskId);
            return new ClientResponseDto<>(404, new Task(), errors);
        }
    }

    public ClientResponseDto<List<Task>> findTaskByName(String taskName) {
        TaskDto taskDto = new TaskDto(taskName, "SampleDescription");
        List<String> errors = validationRequest.checkTask(taskDto);

        if (!errors.isEmpty()) {
            return new ClientResponseDto<>(400, null, errors);
        }
        List<Task> foundedTasks = taskRepository.findTaskByNameStream(taskName);
        if (!foundedTasks.isEmpty()) {
            return new ClientResponseDto<>(200, foundedTasks, errors);
        } else {
            errors.add("Task not found with name: " + taskName);
            return new ClientResponseDto<>(400, null, errors);
        }
    }

    public ClientResponseDto<Boolean> deleteTaskById(Integer taskId) {
        TaskDto taskDto = new TaskDto("SampleName", "SampleDescription");
        List<String> errors = validationRequest.checkTask(taskDto);

        if (!errors.isEmpty()) {
            return new ClientResponseDto<>(400, null, errors);
        }
        boolean taskIsDeleted = taskRepository.removeById(taskId);
        if (taskIsDeleted) {
            return new ClientResponseDto<>(200, true,errors);
        } else {
            errors.add("Task not found with ID: " + taskId);
            return new ClientResponseDto<>(400, null, errors);
        }
    }

    public ClientResponseDto<Task> updateTaskDescriptionById(Integer taskId, String newTaskDescription) {
        TaskDto taskDto = new TaskDto("SampleName", newTaskDescription);
        List<String> errors = validationRequest.checkTask(taskDto);

        if (!errors.isEmpty()) {
            return new ClientResponseDto<>(400, null, errors);
        }
        Optional<Task> optionalTask = taskRepository.update(taskId, newTaskDescription);
        if (optionalTask.isPresent()) {
            Task updatedTask = optionalTask.get();
            return new ClientResponseDto<>(200, updatedTask, errors);
        } else {
            errors.add("Task not found with ID: " + taskId);
            return new ClientResponseDto<>(400, null, errors);
        }
    }
}
