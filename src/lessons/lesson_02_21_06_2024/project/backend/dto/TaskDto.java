package lessons.lesson_02_21_06_2024.project.backend.dto;

public class TaskDto {
    private String taskNameDto;
    private String taskDescriptionDto;

    public TaskDto(String taskNameDto) {
        this.taskNameDto = taskNameDto;
    }

    public TaskDto(String taskNameDto, String taskDescriptionDto) {
        this.taskNameDto = taskNameDto;
        this.taskDescriptionDto = taskDescriptionDto;
    }

    public String getTaskNameDto() {
        return taskNameDto;
    }

    public String getTaskDescriptionDto() {
        return taskDescriptionDto;
    }

    public void setTaskNameDto(String taskNameDto) {
        this.taskNameDto = taskNameDto;
    }

    public void setTaskDescriptionDto(String taskDescriptionDto) {
        this.taskDescriptionDto = taskDescriptionDto;
    }
}
