package project.shoesUp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import project.shoesUp.item.Item;
import project.shoesUp.item.ItemRepository;

import java.util.List;
//아이템의 등록,조회,수정 하는 컨트롤러

@Slf4j
@RequestMapping("/form/items")
@Controller
public class FormItemController {

    private final ItemRepository itemRepository;

    // FormItemController가 스프링 bean에 등록 됨으로써 생성자 주입으로 ItemRepository가 주입된다.
    // 스프링에선 생성자가 딱 하나만 있다면 @Autowired 생략가능
    // 롬복의 @RequiredArgsConstructor를 쓰면 생성자 자동만들어서 아래 전체 생략가능
    @Autowired
    public FormItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "form/itmes";
    }

    @GetMapping({"/{itemId}"})
    public String item(@PathVariable long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "form/item";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        return "form/addForm";
    }



}
