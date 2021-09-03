package project.shoesUp.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import project.shoesUp.domain.member.Member;
import project.shoesUp.domain.member.MemberRepository;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberRepository memberRepository;

   @GetMapping("/")
    public String homeLogin(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Member loginMember, Model model){
            //세션을 찾고, 세션에 들어있는 데이터를 찾는 번거로운 과정을 스프링이 한번에 편리하게 처리해준다

        //세션에 회원 데이터가 없으면
        if(loginMember ==null){
            //return "redirect:/form/items";
            return "home";
        }

        //세션이 유지되면
        model.addAttribute("member", loginMember);

        //return "redirect:form/items/loginItems";
        //return "redirect:/form/items";
        return "loginHome";
    }

//    @GetMapping("/")
//    public String home(){
//        //세션을 찾고, 세션에 들어있는 데이터를 찾는 번거로운 과정을 스프링이 한번에 편리하게 처리해준다
//
//
//        return "redirect:/form/items";
//        //return "redirect:/form/items";
//    }

}
