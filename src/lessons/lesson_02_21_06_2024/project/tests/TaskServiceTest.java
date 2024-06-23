package lessons.lesson_02_21_06_2024.project.tests;

import lessons.lesson_02_21_06_2024.project.backend.dto.ClientResponseDto;
import lessons.lesson_02_21_06_2024.project.backend.dto.TaskDto;
import lessons.lesson_02_21_06_2024.project.backend.entity.Task;
import lessons.lesson_02_21_06_2024.project.backend.repositories.TaskRepository;
import lessons.lesson_02_21_06_2024.project.backend.repositories.TaskRepositoryInterface;
import lessons.lesson_02_21_06_2024.project.backend.service.TaskService;
import lessons.lesson_02_21_06_2024.project.backend.service.validation.ValidationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskRepositoryInterface taskRepository;
    private ValidationRequest validationRequest;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskRepository = new TaskRepository();
        validationRequest = new ValidationRequest();
        taskService = new TaskService(taskRepository, validationRequest);
    }

    @Test
    void addNewTask() {
        TaskDto taskDto = new TaskDto("Brot", "Brot kaufen");
        ClientResponseDto<Task> response = taskService.addNewTask(taskDto);

        assertEquals(200, response.getResponseCode());
        assertEquals("Brot", response.getResponseInfo().getTaskName());
        assertEquals("Brot kaufen", response.getResponseInfo().getTaskDescription());
        assertTrue(response.getErrors().isEmpty());
    }
    @Test
    void addNewTaskWithErrorsExample1() {
        TaskDto taskDto = new TaskDto("", "Brot kaufen");
        ClientResponseDto<Task> response = taskService.addNewTask(taskDto);

        assertEquals(400, response.getResponseCode());
        assertNull(null);
        assertFalse(response.getErrors().isEmpty());
    }
    @Test
    void addNewTaskWithErrorsExample2() {
        TaskDto taskDto = new TaskDto("BROOOOOOOOOOOOOOOOOOT!!!!!!!!!!!!!!!!!", "Brot kaufen");
        ClientResponseDto<Task> response = taskService.addNewTask(taskDto);

        assertEquals(400, response.getResponseCode());
        assertNull(null);
        assertFalse(response.getErrors().isEmpty());
    }

    @Test
    void findTaskById() {
        TaskDto taskDto = new TaskDto("Brot", "Brot kaufen");
        taskRepository.add(new Task(1, taskDto.getTaskNameDto(), taskDto.getTaskDescriptionDto(), false));
        Integer id = 1;
        ClientResponseDto<Task> responseDto = taskService.findTaskById(id);

        assertEquals(200, responseDto.getResponseCode());
        assertEquals("Brot", responseDto.getResponseInfo().getTaskName());
        assertEquals("Brot kaufen", responseDto.getResponseInfo().getTaskDescription());
        assertTrue(responseDto.getErrors().isEmpty());
    }

    @Test
    void findTaskByIdError1() {
        TaskDto taskDto = new TaskDto("Brot", "Brot kaufen");
        taskRepository.add(new Task(1, taskDto.getTaskNameDto(), taskDto.getTaskDescriptionDto(), false));
        Integer id = 3;
        ClientResponseDto<Task> responseDto = taskService.findTaskById(id);

        assertEquals(400, responseDto.getResponseCode());
        assertNull(null);
        assertFalse(responseDto.getErrors().isEmpty());
    }

    @Test
    void findTaskByName() {
        TaskDto taskDto = new TaskDto("Brot", "Brot kaufen");
        taskRepository.add(new Task(1, taskDto.getTaskNameDto(), taskDto.getTaskDescriptionDto(), false));
        String taskName = "Brot";
        ClientResponseDto<List<Task>> responseDto = taskService.findTaskByName(taskName);

        assertEquals(200, responseDto.getResponseCode());
        assertTrue(responseDto.getErrors().isEmpty());
    }
    @Test
    void findTaskByNameError() {
        TaskDto taskDto = new TaskDto("Brot", "Brot kaufen");
        taskRepository.add(new Task(1, taskDto.getTaskNameDto(), taskDto.getTaskDescriptionDto(), false));
        String taskName = "brot";
        ClientResponseDto<List<Task>> responseDto = taskService.findTaskByName(taskName);

        assertEquals(400, responseDto.getResponseCode());
        assertNull(null);
        assertFalse(responseDto.getErrors().isEmpty());
    }
}