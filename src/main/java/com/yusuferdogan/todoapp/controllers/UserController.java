package com.yusuferdogan.todoapp.controllers;
import com.yusuferdogan.todoapp.domain.User;
import com.yusuferdogan.todoapp.session.Session;
import com.yusuferdogan.todoapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/myerror")
    public String error(){
        return "error";
    }

    @RequestMapping({"/",""})
    public String home() {
        System.out.println("Going home...");
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        User existingUser = new User();

        model.addAttribute("login",existingUser);
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model,@ModelAttribute("login") User user){
        System.out.println("@PostMapping(\"/login\") public String login" + user.toString());
        User loginUser = userService.getUserByEmailAndPassword(user.getemail(), user.getPassword());
        if(loginUser != null){
            System.out.println("userService.isEmailPasswordsExist(user.getemail(), user.getPassword()) true");
            Session.user = loginUser;
            return "redirect:/TaskList";
        }
        return "myerror";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user) {
        if(!userService.isUserExist(user.getemail())){
            System.out.println(user);
            userService.addUser(user);
            Session.user = user;
            System.out.println("Session.user : " + Session.user.toString());
            return "register_success";
        }
        return "register_error";

    }

}
