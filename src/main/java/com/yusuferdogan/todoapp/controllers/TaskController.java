package com.yusuferdogan.todoapp.controllers;

import com.yusuferdogan.todoapp.domain.Task;
import com.yusuferdogan.todoapp.session.Session;
import com.yusuferdogan.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// httpReq ----> controller -----> Service ---->  Repository
// frontEnd <---- controller <---- service <------
@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/TaskList", method = RequestMethod.GET)
    public String getAllTasks(Model model) {
        System.out.println("@RequestMapping(value = \"/tasks\",method = RequestMethod.GET)\n" + "public String getAllTasks(Model model){");
        for (Task t : taskService.getAllTasks()) {
            System.out.println(t);
        }
        System.out.println("------------------------------------\n\n");
        model.addAttribute("tasks",
                taskService.getAllTasksOfUser(Session.user.getemail(), Session.user.getPassword()));
        return "TaskList";
    }

    @RequestMapping(value = "/update-task", method = RequestMethod.GET)
    public String showUpdateTaskPage(@RequestParam long id, ModelMap model) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
        }
        return "update-task";
    }

    @RequestMapping(value = "/update-task", method = RequestMethod.POST)
    public String updateTask(Model model, Task task, BindingResult result) {

        if (result.hasErrors()) {
            return "update-task";
        }

        task.setUser(Session.user);
        taskService.updateTask(task);
        System.out.println("---------------------");
        model.addAttribute("tasks", taskService.getAllTasksOfUser(Session.user.getemail(), Session.user.getPassword()));
        return "redirect:/TaskList";
    }


    @GetMapping("/delete-task")
    public String deleteTask(Model model, @RequestParam Long id) {
        taskService.removeTask(id);
        model.addAttribute("task", taskService.getAllTasksOfUser(Session.user.getemail(), Session.user.getPassword()));

        return "redirect:/TaskList";
    }

    @GetMapping("/add-task")
    public String showForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);

        return "add-task";
    }

    @PostMapping("/add-task")
    public String submitForm(@ModelAttribute("task") Task task, Model model, BindingResult result) {

        if (result.hasErrors()) {
            return "add-task";
        }


        task.setUser(Session.user);
        taskService.addTask(task);

        System.out.println("\n\n\n\npublic String submitForm(@ModelAttribute(\"task\") Task task) {\n");
        for (Task t : taskService.getAllTasks()) {
            System.out.println(t);
        }
        System.out.println("---------------------\n\n\n");

        model.addAttribute("tasks", taskService.getAllTasksOfUser(Session.user.getemail(), Session.user.getPassword()));


        return "redirect:/TaskList";
    }

}
