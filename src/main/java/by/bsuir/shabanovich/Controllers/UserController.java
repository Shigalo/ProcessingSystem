package by.bsuir.shabanovich.Controllers;

import by.bsuir.shabanovich.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")

@Controller
public class UserController {
    @Autowired
    WorkerService userService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        return "accountWork/profile";
    }

    /*@GetMapping("/edit")
    public String edit(Model model,
                       @RequestParam String name,
                       @RequestParam String surname) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/profile";
    }

    @PostMapping("/edit")
    public String editPost(Model model,
                       @RequestParam String name,
                       @RequestParam String surname) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/profile";
    }*/

    @GetMapping("/addUser")
    public String userForm(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "accountWork/registration";
    }

    @PostMapping("/addUser")
    public String addUser(Model model,
                          @RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String name,
                          @RequestParam String surname,
                          @RequestParam String role) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        userService.addUser(username, password, name, surname, role);
        return "redirect:/workers";
    }

    /*@GetMapping("/userRemove")
    public String remove(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/";
    }*/
}
