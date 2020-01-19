package by.bsuir.shabanovich.Controllers;

import by.bsuir.shabanovich.Services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stocks")
public class StocksController {

    @Autowired
    WorkerService userService;

    @GetMapping("/list")
    public String addTransport(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "stocks/list";
    }

    @GetMapping("/useWarehouse/{warehouseId}")
    public String useWarehouse(Model model, @PathVariable Integer warehouseId, @RequestParam Integer productId) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "/stocks/use";
    }

    @PostMapping("/useWarehouse/{warehouseId}")
    public String useWarehouseStock(Model model,
                                    @PathVariable Integer warehouseId,
                                    @RequestParam Integer productId,
                                    @RequestParam Integer quantity) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/warehouse/info/" + warehouseId;
    }

    @GetMapping("/getWarehouse/{warehouseId}")
    public String getWarehouse(Model model, @PathVariable Integer warehouseId, @RequestParam Integer productId) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "/stocks/get";
    }

    @PostMapping("/getWarehouse/{warehouseId}")
    public String getWarehouseStock(Model model,
                                    @PathVariable Integer warehouseId,
                                    @RequestParam Integer productId,
                                    @RequestParam Integer quantity) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/warehouse/info/" + warehouseId;
    }

    @GetMapping("/use/{id}")
    public String use(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "/stocks/use";
    }

    @PostMapping("/use/{id}")
    public String useStock(Model model,
                           @PathVariable Integer id,
                           @RequestParam Integer quantity) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/stocks/list";
    }

    @GetMapping("/get/{id}")
    public String get(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "/stocks/get";
    }

    @PostMapping("/get/{id}")
    public String getStock(Model model,
                           @PathVariable Integer id,
                           @RequestParam Integer quantity) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/stocks/list/";
    }
}
