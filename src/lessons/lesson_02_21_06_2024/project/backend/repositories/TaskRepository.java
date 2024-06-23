package lessons.lesson_02_21_06_2024.project.backend.repositories;

import lessons.lesson_02_21_06_2024.project.backend.entity.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements TaskRepositoryInterface {

    private Integer taskId = 0;

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
    public Optional<Task> update(Integer taskId, String newTaskDescription) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setTaskDescription(newTaskDescription);
                return Optional.of(task);
            }
        }
        return Optional.empty();
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

    // alternativ:
    public boolean deleteById(Integer id) {
        Optional<Task> foundedTaskById = findById(id);

        if (foundedTaskById.isPresent()) {
            tasks.remove(foundedTaskById.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Task> findById(Integer taskId) {
        for (Task currentTask : tasks) {
            if (currentTask.getTaskId().equals(taskId)) {
                return Optional.of(currentTask);
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
//alternativ über stream:
    public Optional<Task> findByIdStream(Integer taskId) {
        return tasks.stream()
                .filter(currentTask -> currentTask.getTaskId().equals(taskId))
                .findFirst();
    }
    @Override
    public List<Task> findTaskByNameStream(String taskName) {
        return tasks.stream()
                .filter(currentTask -> currentTask.getTaskName().equals(taskName))
                .toList();
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }
}
