package by.bsuir.shabanovich.Controllers;

import by.bsuir.shabanovich.Entities.Order;
import by.bsuir.shabanovich.Services.OrderService;
import by.bsuir.shabanovich.Services.NomenclatureService;
import by.bsuir.shabanovich.Services.WorkerService;
import by.bsuir.shabanovich.Supporting.WordReportCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public String list(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("orders", orderService.findAll());
        return "orders/list";
    }

    @GetMapping("/ready")
    public String readyList(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("orders", orderService.findReady());
        return "orders/ready";
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        model.addAttribute("nomenclatures", nomenclatureService.findAll());
        return "orders/add";
    }

    @PostMapping("/add")
    public String addNomenclature(@RequestParam String name,
                                  @RequestParam String address,
                                  @RequestParam Integer[] nomenclature,
                                  @RequestParam Integer[] count,
                                  Model model) {
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("isLogin", userService.isLogin());
        orderService.addOrder(nomenclature, count, name, address);

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

    @GetMapping("/route")
    public String route(Model model, @RequestParam String ids) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        List<String> list = Arrays.asList(ids.split(","));
        List<Order> orderList = new ArrayList<>();
        for(String s : list)
            orderList.add(orderService.findById(Integer.valueOf(s)));
        for(int i = 0; i < orderList.size();)
            orderList.get(i).setPosition(++i);

        model.addAttribute("orders", orderList);
        return "/orders/route";
    }

    private String path;

    @PostMapping("/route")
    public String print(Model model,
                        @RequestParam String date,
                        @RequestParam Integer[] pos) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        System.out.println(date);
        for(int i : pos){
            System.out.println(i);
        }
        path = "D:\\" + date + " route.docx";

        WordReportCreator creator = new WordReportCreator(path);

        for(int i = 1; i < 11; i++)
            creator.PushData(String.valueOf(i), String.valueOf(i * 10 + 5));
        creator.Create();

        return "/orders/download";
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public void getSteamingFile1(HttpServletResponse response) throws IOException {
        response.setContentType("application/docx");

        response.setHeader("Content-Disposition", "attachment; filename=\"route.docx\"");
        InputStream inputStream = new FileInputStream(new File(path));
        int nRead;
        while ((nRead = inputStream.read()) != -1) {
            response.getWriter().write(nRead);
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        orderService.remove(id);
        return "redirect:/orders/list";
    }
}
