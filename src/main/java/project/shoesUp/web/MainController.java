package project.shoesUp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(){
        return "redirect:/form/items";
    }

    @GetMapping("/main")
    public String main(){
        return "/form/items";
    }

}
