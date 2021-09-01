package project.shoesUp.web.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.shoesUp.domain.login.LoginService;
import project.shoesUp.domain.member.Member;
import project.shoesUp.web.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form){ //?
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }
        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
        if(loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            //reject:글로벌오류, DB까지 뒤져야 알 수 있는 오류(필드, 오브젝트오류x)
            return "login/loginForm";
        }

        //로그인 성공처리
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();

        //세션에 로그인 회원 정보를 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:/";
    }

//    request.getSession(true)
//    세션이 있으면 기존 세션을 반환한다.
//    세션이 없으면 새로운 세션을 생성해서 반환한다.
//
//    request.getSession(false)
//    세션이 있으면 기존 세션을 반환한다.
//    세션이 없으면 새로운 세션을 생성하지 않는다. null 을 반환한다.

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){ //쿠키값을 꺼내야하기 때문에 request
        HttpSession session = request.getSession(false ); //세션을 없애는게 목적이기 때문에
        if(session != null){
            session.invalidate(); //세션과 그 안에 있는 데이터가 날라간다
        }
   //     return "redirect:/";
        return "redirect:form/items";
    }




}
