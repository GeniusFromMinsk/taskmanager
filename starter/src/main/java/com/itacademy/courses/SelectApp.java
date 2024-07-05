package com.itacademy.courses;

import com.itacademy.courses.models.Task;
import com.itacademy.courses.services.TaskService;

import java.util.List;

public class SelectApp {
    private final TaskService taskService;

    public SelectApp() {
        this.taskService = new TaskService();
    }

    public void start() {
        selectTaskById();
        selectAllTasks();
        selectTasksByStatus();
        selectTasksByPriority();
    }

    private void selectTaskById() {
        int taskId = 1; // Установите существующий ID задачи
        Task task = taskService.getTaskById(taskId);
        if (task != null) {
            System.out.println("Выбранная задача по ID: " + task);
        } else {
            System.err.println("Задача с ID " + taskId + " не найдена.");
        }
    }

    private void selectAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        System.out.println("Все задачи:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private void selectTasksByStatus() {
        String status = "В работе"; // Установите нужный статус
        List<Task> tasks = taskService.getTasksByStatus(status);
        System.out.println("Задачи со статусом " + status + ":");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private void selectTasksByPriority() {
        String priority = "high"; // Установите нужный приоритет
        List<Task> tasks = taskService.getTasksByPriority(priority);
        System.out.println("Задачи с приоритетом " + priority + ":");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
