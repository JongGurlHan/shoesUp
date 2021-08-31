package project.shoesUp.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.shoesUp.domain.member.Member;
import project.shoesUp.domain.member.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){
//        Optional<Member> findMemberOptional = memberRepository.findByLoginId(loginId);

//        Member member = findMemberOptional.get();
//
//        if(member.getPassword().equals(password)){
//            return member;
//        }else{
//            return null;
//        }

        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password)) //optional안에 들어있는 멤버의 비번이 비번과 같은가 같으면 m 리턴
                .orElse(null);//같지 않으면 null반환해

            }
}
