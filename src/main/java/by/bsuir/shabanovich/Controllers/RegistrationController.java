package by.bsuir.shabanovich.Controllers;

import by.bsuir.shabanovich.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    WorkerService userService;

    @GetMapping
    public String setForm(Model  model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "accountWork/registration";
    }

    @PostMapping
    public String getForm(@RequestParam String username,
                          @RequestParam String surname,
                          @RequestParam String phone,
                          @RequestParam String password,
                          @RequestParam String passwordConfirm,
                          @RequestParam String mail,
                          Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        if(!password.equals(passwordConfirm)) {
            model.addAttribute("error", "Пароли не совпадают!");
            model.addAttribute("username", username);
            model.addAttribute("surname", surname);
            model.addAttribute("phone", phone);
            model.addAttribute("password", password);
            model.addAttribute("mail", mail);
            return "accountWork/registration";
        }

        return "redirect:/login";
    }
}
