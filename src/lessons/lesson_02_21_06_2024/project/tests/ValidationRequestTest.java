package lessons.lesson_02_21_06_2024.project.tests;

import lessons.lesson_02_21_06_2024.project.backend.dto.TaskDto;
import lessons.lesson_02_21_06_2024.project.backend.service.validation.ValidationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class ValidationRequestTest {
    ValidationRequest validationRequest;
    TaskDto taskDto;
    @BeforeEach
    void setUp() {
        validationRequest = new ValidationRequest();
    }
    @Test
    void testValidTask() {
        TaskDto taskDto = new TaskDto("Brot", "Brot kaufen");
        List<String> errors = validationRequest.checkTask(taskDto);
        assertTrue(errors.isEmpty(), "Expected no validation errors, but got: " + errors);
    }

    @Test
    void testInvalidTaskName() {
        TaskDto taskDto = new TaskDto("","Brot kaufen");
        List<String> errors = validationRequest.checkTask(taskDto);
        assertFalse(errors.isEmpty(), "Expected validation errors for task name, but got none.");
    }

    @Test
    void testInvalidTaskDescription() {
        TaskDto taskDto = new TaskDto("Brot","");
        List<String> errors = validationRequest.checkTask(taskDto);
        assertFalse(errors.isEmpty(), "Expected validation errors for task name, but got none.");
    }

    @Test
    void testInvalidTaskNameLong() {
        TaskDto taskDto = new TaskDto("Brot , eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","Brot kaufen");
        List<String> errors = validationRequest.checkTask(taskDto);
        assertFalse(errors.isEmpty(), "Expected validation errors for task name, but got none.");
    }
    @Test
    void testInvalidTaskNameShort() {
        TaskDto taskDto = new TaskDto("Br","Brot kaufen");
        List<String> errors = validationRequest.checkTask(taskDto);
        assertFalse(errors.isEmpty(), "Expected validation errors for task name, but got none.");
    }
    @Test
    void testInvalidTaskDescriptionLong() {
        TaskDto taskDto = new TaskDto("Brot","Brot kaufen , eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        List<String> errors = validationRequest.checkTask(taskDto);
        assertFalse(errors.isEmpty(), "Expected validation errors for task name, but got none.");
    }
    @Test
    void testInvalidTaskDescriptionShort() {
        TaskDto taskDto = new TaskDto("Brot","Br");
        List<String> errors = validationRequest.checkTask(taskDto);
        assertFalse(errors.isEmpty(), "Expected validation errors for task name, but got none.");
    }
}
