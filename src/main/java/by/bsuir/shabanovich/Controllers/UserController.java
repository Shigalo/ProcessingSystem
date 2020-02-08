package by.bsuir.shabanovich.Controllers;

import by.bsuir.shabanovich.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")

@Controller
@RequestMapping("/user")
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
        model.addAttribute("access", "true");
        model.addAttribute("user", userService.getCurrentUser());
        return "accountWork/profile";
    }

    @GetMapping("/add")
    public String userForm(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "accountWork/registration";
    }

    @PostMapping("/add")
    public String addUser(Model model,
                          @RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String name,
                          @RequestParam String surname,
                          @RequestParam String role) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        userService.addUser(username, password, name, surname, role);
        model.addAttribute("massage", "Сотрудник добавлен");
        return "redirect:/workers";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("user", userService.getCurrentUser());

        return "accountWork/edit";
    }

    @PostMapping("/edit")
    public String editPost(Model model,
                           @RequestParam String name,
                           @RequestParam String surname) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        userService.edit(name, surname);

        return "redirect:/user/profile";
    }


    @GetMapping("/edit_password")
    public String editPassword(Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        return "accountWork/password";
    }

    @PostMapping("/edit_password")
    public String editPasswordPost(Model model,
                                   @RequestParam String oldPassword,
                                   @RequestParam String password,
                                   @RequestParam String passwordConfirm) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        int result = userService.editPassword(oldPassword, password, passwordConfirm);
        switch (result) {
            case 1:
                model.addAttribute("massage", "Неверный старый пароль");
                return "accountWork/password";
            case 2:
                model.addAttribute("massage", "Новый и страй пароли совпадают");
                return "accountWork/password";
            case 3:
                model.addAttribute("massage", "Пароли не совпадают");
                return "accountWork/password";
            default:
                return "redirect:/user/profile";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model,
                         @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        String massage = userService.deleteById(id) ? "Пользователь удалён" : "Ошибка удаления";
        model.addAttribute("massage", massage);
        return "redirect:/workers";
    }
}
