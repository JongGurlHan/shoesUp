package project.shoesUp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.shoesUp.form.ItemSaveForm;
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

    //메인페이지 - 전체 조회
    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "form/items";
    }

    //각 상품별 조회
    @GetMapping({"/{itemId}"})
    public String item(@PathVariable long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "form/item";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("item", new Item());
        return "form/addForm";
    }

    @PostMapping("/add")
    public String addItem(@Validated @ModelAttribute("item") ItemSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        log.info("objectName={}", bindingResult.getObjectName());
        log.info("target={}", bindingResult.getTarget());

        //검증에 실패하면 다시 입력 폼으로
        if(bindingResult.hasErrors()){
            log.info("error ={}", bindingResult);
            //bindingResult는 자동으로 뷰로 넘어가기 때문에 굳이 model.addAttribute에 넣지 않아도 된다.
            return "/form/addForm";
        }

        //성공로직
        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setDate(form.getDate());
        item.setReleaseTime(form.getReleaseTime());

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/form/items/{itemId}";
    }


    // 각 상품별 수정 폼 이동
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "form/editForm";
    }

    @PostMapping("/{itemId}edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item){
        itemRepository.update(itemId, item);
        return "redirect:/form/items/{itemId}";
    }




}
