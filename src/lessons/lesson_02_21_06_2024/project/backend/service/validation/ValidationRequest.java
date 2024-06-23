package lessons.lesson_02_21_06_2024.project.backend.service.validation;

import lessons.lesson_02_21_06_2024.project.backend.dto.TaskDto;

import java.util.ArrayList;
import java.util.List;

public class ValidationRequest {
    public List<String> checkTask(TaskDto taskDto) {
        List<String> errors = new ArrayList<>();

        if (taskDto.getTaskNameDto().isBlank()) {
            errors.add("Task name must be not null \n");
        }
        if (taskDto.getTaskDescriptionDto().isBlank()) {
            errors.add("Task description must be not null \n");
        }
        if (taskDto.getTaskNameDto().length() < 3) {
            errors.add("Task name cannot be less than 3 letters \n");
        }
        if (taskDto.getTaskNameDto().length() > 15) {
            errors.add("Task name cannot be more then 15 letters \n");
        }
        if (taskDto.getTaskDescriptionDto().length() < 3) {
            errors.add("Task description cannot be less than 3 letters \n");
        }
        if (taskDto.getTaskDescriptionDto().length() > 30) {
            errors.add("Task description cannot be more then 30 letters \n");
        }
        return errors;
    }

    public List<String> checkTaskDescription(String taskDescription) {
        List<String> errors = new ArrayList<>();

        if (taskDescription.isBlank()) {
            errors.add("Task description must be not null \n");
        }
        if (taskDescription.length() < 3) {
            errors.add("Task description cannot be less than 3 letters \n");
        }
        if (taskDescription.length() > 30) {
            errors.add("Task description cannot be more than 30 letters \n");
        }

        return errors;
    }
}
