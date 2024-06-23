package lessons.lesson_02_21_06_2024.project;

import lessons.lesson_02_21_06_2024.project.backend.repositories.TaskRepository;
import lessons.lesson_02_21_06_2024.project.backend.repositories.TaskRepositoryInterface;
import lessons.lesson_02_21_06_2024.project.backend.service.TaskService;
import lessons.lesson_02_21_06_2024.project.backend.service.validation.ValidationRequest;
import lessons.lesson_02_21_06_2024.project.frontend.ui.UI;

public class App {
    public static void main(String[] args) {
        TaskRepositoryInterface taskRepository = new TaskRepository();
        ValidationRequest validationRequest = new ValidationRequest();
        TaskService taskService = new TaskService(taskRepository, validationRequest);
        UI ui = new UI(taskService);
        ui.start();
    }
}
