package by.bsuir.shabanovich.Controllers;

import by.bsuir.shabanovich.Services.OrderService;
import by.bsuir.shabanovich.Services.NomenclatureService;
import by.bsuir.shabanovich.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    WorkerService userService;

    @Autowired
    NomenclatureService nomenclatureService;

    @Autowired
    OrderService orderService;

    @GetMapping("/list")
    public String addTransport(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("orders", orderService.findAll());
        return "orders/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("nomenclatures", nomenclatureService.findAll());
        return "orders/add";
    }

    @PostMapping("/add")
    public String addNomenclature(@RequestParam Integer[] nomenclature,
                                  @RequestParam Integer[] count,
                                  Model model) {
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("isLogin", userService.isLogin());
        orderService.addOrder(nomenclature, count);

        return "redirect:/orders/list";
    }

    @GetMapping("/info/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("order", orderService.findById(id));
        model.addAttribute("products", orderService.findProducts(id));
        return "orders/info";
    }

    /*@GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("nomenclature", nomenclatureService.findById(id));
        return "orders/edit";
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

        return "redirect:/orders/list";
    }
*/
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

    /*@GetMapping("/remove/{id}")
    public String remove(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        nomenclatureService.remove(id);
        return "redirect:/orders/list";
    }*/
}
