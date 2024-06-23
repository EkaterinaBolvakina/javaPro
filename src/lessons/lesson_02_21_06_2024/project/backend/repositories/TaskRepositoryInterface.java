package lessons.lesson_02_21_06_2024.project.backend.repositories;

import lessons.lesson_02_21_06_2024.project.backend.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryInterface {
    public Task add(Task newTask);
    public Task update(Task taskToUpdate);
    public boolean removeById(Integer taskId);
    public Optional<Task> findById(Integer taskId);
    public Optional<Task> findByTaskName(String taskName);
    public List<Task> findAll();


}
