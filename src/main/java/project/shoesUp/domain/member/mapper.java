package project.shoesUp.domain.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
interface MemberMapper {

    @Insert("insert into user_table (id, loginId, name, password)" +
            "values(#{id}, #{loginId}, #{name}, #{password})")
    void addUserInfo(Member member);
}
