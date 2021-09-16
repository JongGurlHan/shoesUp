package project.shoesUp.web.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.shoesUp.domain.member.Member;
import project.shoesUp.domain.member.MemberRepository;
import project.shoesUp.domain.member.MemberService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member){
        return  "members/addMemberForm";
    }


    @PostMapping("/add")
   public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return  "members/addMemberForm";
        }
        memberService.addMemberInfo(member);
        //memberRepository.save(member);
        return "redirect:/";
    }


}
