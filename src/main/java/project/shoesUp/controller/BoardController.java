package project.shoesUp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/instock")
    public String instock(){
        return "board/instock";
    }
    @GetMapping("/freeBoard")
    public String freeBoard(){
        return "board/freeBoard";
    }
    @GetMapping("/read")
    public String read(){
        return "board/read";
    }


}
