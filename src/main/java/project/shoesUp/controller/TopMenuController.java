package project.shoesUp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.shoesUp.service.TopMenuService;

@Controller
public class TopMenuController {

    @Autowired
    TopMenuService topMenuService;

    @GetMapping("/board/freeBoard")
    private void getTopMenuList(){
        topMenuService.
    }




}
