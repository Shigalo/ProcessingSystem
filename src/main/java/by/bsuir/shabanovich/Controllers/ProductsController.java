package by.bsuir.shabanovich.Controllers;

import by.bsuir.shabanovich.Services.CollectionService;
import by.bsuir.shabanovich.Services.ProductService;
import by.bsuir.shabanovich.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    WorkerService userService;

    @Autowired
    ProductService productService;

    @Autowired
    CollectionService collectionService;

    @GetMapping("/list")
    public String addTransport(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("products", productService.findAll());
        return "products/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("collections", collectionService.findAll());
        return "products/add";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam String factory,
                             @RequestParam String count,
                             @RequestParam String collection,
                             @RequestParam String wholesale,
                             @RequestParam String retail,
                             @RequestParam String article,
                             Model model) {
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("isLogin", userService.isLogin());
        productService.addProduct(name, factory, count, collection, wholesale, retail, article);

        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("product", productService.findById(id));
        model.addAttribute("collections", collectionService.findAll());
        return "products/edit";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id,
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
        productService.editProduct(id, name, factory, count, collection, wholesale, retail, article);

        return "redirect:/product/list";
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

        productService.remove(id);
        return "redirect:/product/list";
    }
}
