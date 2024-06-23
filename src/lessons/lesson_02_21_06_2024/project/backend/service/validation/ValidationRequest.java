package lessons.lesson_02_21_06_2024.project.backend.service.validation;

import lessons.lesson_02_21_06_2024.project.backend.dto.TaskDto;

import java.util.ArrayList;
import java.util.List;

public class ValidationRequest {
    public boolean checkTaskName(TaskDto taskDto) {
        List<String> errors = new ArrayList<>();
        String taskName = taskDto.getTaskNameDto();
        if (taskName.isBlank()) {
            errors.add("Task name must be not null \n");
        }
        if ( (taskName.isEmpty()) || (taskName.length() > 40) ) {
            errors.add("Task name must be between 1 and 40 letters \n");
        }
        if (!errors.isEmpty()) throw new RuntimeException(errors.toString());
        return  true;
    }
}
