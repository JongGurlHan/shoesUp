package project.shoesUp.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    @Autowired
    private MemberMapper memberMapper;

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //회원저장
    public Member save(Member member){
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    //회원조회
    public Member findById(Long id){
        return store.get(id);
    }

    public Optional<Member>findByLoginId(String loginId){
        List<Member>all = findAll();
        for (Member m : all) {
            if(m.getLoginId().equals(loginId)){
                return Optional.of(m);
            }
        }
        return Optional.empty();
    }
    //자바8 람다버전
//    return findAll().stream() //list를 stream으로 바꾼다
//        .filter(m -> m.getLoginId().equals(loginId)) //filter: 괄호안을 만족해야 다음으로 넘어간다. /루프안에서 m.getLoginId().equals(loginId) 일때만 넘어간다.
//        .findFirst(); //먼저 나오는애를 받아서 반환한다.

    //전체회원조회
    public List<Member>findAll(){
        return new ArrayList<>(store.values());
    }

    //테스트 하고 초기화위해서
    public void clearStore(){
        store.clear();
    }



}