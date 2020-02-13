package by.bsuir.shabanovich.Controllers;

import by.bsuir.shabanovich.Services.NomenclatureService;
import by.bsuir.shabanovich.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nomenclature")
public class NomenclatureController {

    @Autowired
    WorkerService userService;

    @Autowired
    NomenclatureService nomenclatureService;

    @GetMapping("/list")
    public String addTransport(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("nomenclatures", nomenclatureService.findAll());
        return "nomenclatures/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        return "nomenclatures/add";
    }

    @PostMapping("/add")
    public String addNomenclature(@RequestParam String name,
                             @RequestParam String factory,
                             @RequestParam String count,
                             @RequestParam String collection,
                             @RequestParam String wholesale,
                             @RequestParam String retail,
                             @RequestParam String article,
                             Model model) {
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("isLogin", userService.isLogin());
        nomenclatureService.addNomenclature(name, factory, collection, wholesale, retail, article);

        return "redirect:/nomenclature/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("nomenclature", nomenclatureService.findById(id));
        return "nomenclatures/edit";
    }

    @PostMapping("/edit/{id}")
    public String editNomenclature(@PathVariable Integer id,
                              @RequestParam String name,
                              @RequestParam String factory,
                              @RequestParam String count,
                              @RequestParam String collection,
                              @RequestParam String wholesale,
                              @RequestParam String retail,
                              @RequestParam String article,
                              Model model) {
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("isLogin", userService.isLogin());
        nomenclatureService.editNomenclature(id, name, factory, count, collection, wholesale, retail, article);

        return "redirect:/nomenclature/list";
    }

   /* @GetMapping("/info/{id}")
    public String info(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "products/info";
    }*/

    /*@PostMapping("/info/{id}")
    public String saveInfo(Model model, @PathVariable Integer id,
                           @RequestParam String name,
                           @RequestParam String type) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/products/info/" + id;
    }*/

    @GetMapping("/remove/{id}")
    public String remove(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        nomenclatureService.remove(id);
        return "redirect:/nomenclature/list";
    }
}
