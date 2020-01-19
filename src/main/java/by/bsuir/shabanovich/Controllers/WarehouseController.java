package by.bsuir.shabanovich.Controllers;

import by.bsuir.shabanovich.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WorkerService userService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "warehouse/list";
    }

    @PostMapping("/add")
    public String create(@RequestParam String address, Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/warehouse/info/";
    }

    @GetMapping("/subscribe/{id}")
    public String subscribe(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/warehouse/info/" + id;
    }

    @GetMapping("/info/{id}")
    public String getInfo(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "warehouse/info";
    }

    @PostMapping("/info/{id}")
    public String setInfo(Model model, @PathVariable Integer id,
                          @RequestParam String address) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/warehouse/info/" + id;
    }

    @PostMapping("/addProduct/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addProduct(Model model,
                             @RequestParam String productData,
                             @RequestParam Integer level,
                             @RequestParam Integer initialStock,
                             @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/warehouse/info/"+id;
    }

    @GetMapping("/remove/{warehouseId}")
    public String remove(Model model, @PathVariable Integer warehouseId, @RequestParam Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/warehouse/info/"+warehouseId;
    }

    @GetMapping("/use/{warehouseId}")
    public String use(Model model, @PathVariable Integer warehouseId, @RequestParam Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/stocks/useWarehouse/" + warehouseId + "?productId=" + id;
    }

    @GetMapping("/get/{warehouseId}")
    public String get(Model model, @PathVariable Integer warehouseId, @RequestParam Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/stocks/getWarehouse/" + warehouseId + "?productId=" + id;
    }

    @GetMapping("/removeWarehouse/{id}")
    public String removeWarehouse(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/warehouse/list";
    }
}
