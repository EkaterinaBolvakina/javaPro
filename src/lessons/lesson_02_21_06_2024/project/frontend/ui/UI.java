package lessons.lesson_02_21_06_2024.project.frontend.ui;

import lessons.lesson_02_21_06_2024.project.backend.dto.ClientResponseDto;
import lessons.lesson_02_21_06_2024.project.backend.dto.TaskDto;
import lessons.lesson_02_21_06_2024.project.backend.entity.Task;
import lessons.lesson_02_21_06_2024.project.backend.service.TaskService;

import java.util.List;
import java.util.Scanner;

public class UI {
    private final TaskService taskService;

    public UI(TaskService taskService) {
        this.taskService = taskService;
    }

    public void start() {
        while (true) {
            System.out.println("Please enter your choice: ");
            System.out.println("1. Add new task");
            System.out.println("2. Find task by ID");
            System.out.println("3. Find task by name");
            System.out.println("4. Update task description");
            System.out.println("5. Delete task by ID");
            System.out.println("6. Exit");

            Scanner scanner = new Scanner(System.in);

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    System.out.println("Please enter task name:");
                    String taskName = scanner.nextLine();
                    System.out.println("Please enter task description:");
                    String taskDesc = scanner.nextLine();

                    ClientResponseDto<Task> clientResponseDto = taskService.addNewTask(new TaskDto(taskName, taskDesc));

                    if (clientResponseDto.getResponseCode() == 200) {
                        System.out.println("Task is added successfully");
                        System.out.println(clientResponseDto.getResponseInfo());
                    } else {
                        System.out.println(clientResponseDto.getErrors());
                    }
                    break;
                case 2:
                    System.out.println("Please enter task ID:");
                    Integer taskId = scanner.nextInt();

                    ClientResponseDto<Task> clientResponseDtoFindById = taskService.findTaskById(taskId);

                    if (clientResponseDtoFindById.getResponseCode() == 200) {
                        System.out.println("Task is founded successfully");
                        System.out.println(clientResponseDtoFindById.getResponseInfo().getTaskName());
                        System.out.println(clientResponseDtoFindById.getResponseInfo().getTaskDescription());
                    } else {
                        System.out.println(clientResponseDtoFindById.getErrors());
                    }
                    break;
                case 3:
                    System.out.println("Please enter task name:");
                    String taskNameForSearch = scanner.nextLine();

                    ClientResponseDto<List<Task>> clientResponseDtoFindByName = taskService.findTaskByName(taskNameForSearch);

                    if (clientResponseDtoFindByName.getResponseCode() == 200) {
                        System.out.println("Task is founded successfully");
                        System.out.println(clientResponseDtoFindByName.getResponseInfo());
                    } else {
                        System.out.println(clientResponseDtoFindByName.getErrors());
                    }
                    break;
                case 4:
                    System.out.println("Please enter task ID:");
                    Integer taskIdToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter new task description:");
                    String taskDescriptionForUpdate = scanner.nextLine();

                    ClientResponseDto<Task> clientResponseDtoUpdatedDescById = taskService.updateTaskDescriptionById(taskIdToUpdate, taskDescriptionForUpdate);

                    if (clientResponseDtoUpdatedDescById.getResponseCode() == 200) {
                        System.out.println("Task description is updated successfully");
                        System.out.println(clientResponseDtoUpdatedDescById.getResponseInfo().getTaskName());
                        System.out.println(clientResponseDtoUpdatedDescById.getResponseInfo().getTaskDescription());
                    } else {
                        System.out.println(clientResponseDtoUpdatedDescById.getErrors());
                    }
                    break;
                case 5:
                    System.out.println("Please enter task ID:");
                    Integer taskIdToDelete = scanner.nextInt();

                    ClientResponseDto<Boolean> clientResponseDtoDeleteById = taskService.deleteTaskById(taskIdToDelete);

                    if (clientResponseDtoDeleteById.getResponseCode() == 200) {
                        System.out.println("Task with Id: "+taskIdToDelete +" is deleted successfully");
                    } else {
                        System.out.println(clientResponseDtoDeleteById.getErrors());
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
