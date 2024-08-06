package com.itacademy.courses;

import com.itacademy.courses.models.Task;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.TaskService;
import com.itacademy.courses.enums.TaskFilter;
import com.itacademy.courses.services.UserService;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TaskStarter {
    public static void main(String[] args) throws ParseException {
        TaskService taskService = new TaskService();
        UserService userService = new UserService();

        User user = userService.getUserById(36);
        if (user == null) {
            System.out.println("Пользователь с ID 36 не найден.");
            return;
        }

        Task newTask = new Task();
        newTask.setUser(user);
        newTask.setTitle("New Task");
        newTask.setDescription("Description of the new task");
        newTask.setStatus("Pending");
        newTask.setPriority("High");
        newTask.setDueDate(new Date(124, Calendar.AUGUST, 23)); // Установите значение для due_date
        String dateString = "2024-08-24 14:00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(dateString);
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        newTask.setReminderTime(timestamp);
        taskService.addTask(newTask);

        newTask.setTitle("Updated Task");
        taskService.updateTask(newTask);

        Task task = taskService.getTaskById(newTask.getTaskId());
        System.out.println(task);

        taskService.deleteTask(newTask.getTaskId());

        List<Task> tasks = taskService.getAllTasks();
        tasks.forEach(System.out::println);

        List<Task> filteredTasks = taskService.getTasksByFilter(TaskFilter.BY_STATUS, "Pending");
        filteredTasks.forEach(System.out::println);
    }
}
