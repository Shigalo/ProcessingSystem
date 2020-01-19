package by.bsuir.shabanovich.Controllers;

import by.bsuir.shabanovich.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    WorkerService userService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "homepage";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    public String profile(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "accountWork/profile";
    }

    @GetMapping("/edit")
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
    }

    @GetMapping("/userRemove")
    public String remove(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/";
    }
}
