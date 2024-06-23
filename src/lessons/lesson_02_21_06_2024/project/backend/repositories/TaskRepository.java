package lessons.lesson_02_21_06_2024.project.backend.repositories;

import lessons.lesson_02_21_06_2024.project.backend.entity.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements TaskRepositoryInterface {

    private int taskId = 0;

    private List<Task> tasks;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public Task add(Task newTask) {
        newTask.setTaskId(++taskId);
        tasks.add(newTask);
        return newTask;
    }

    @Override
    public Task update(Task taskToUpdate) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskToUpdate.getTaskId())) {
                String taskDesc = taskToUpdate.getTaskDescription();
                task.setTaskDescription(taskDesc);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task is not exist");
        }
        return taskToUpdate;
    }

    @Override
    public boolean removeById(Integer taskId) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTaskId().equals(taskId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Task> findById(Integer taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Task> findByTaskName(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equals(taskName)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }
}
