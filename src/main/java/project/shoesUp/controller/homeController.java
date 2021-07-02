package project.shoesUp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.shoesUp.service.TestService;

@Controller
public class homeController {

    @GetMapping("/")
    public String home(){

        return "redirect:/main";
    }
}
