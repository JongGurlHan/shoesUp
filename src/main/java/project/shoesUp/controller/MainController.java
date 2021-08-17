package project.shoesUp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(){
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(){
        return "/form/itemsTest";
    }

}
