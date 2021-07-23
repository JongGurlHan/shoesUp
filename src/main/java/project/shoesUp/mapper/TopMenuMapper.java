package project.shoesUp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import project.shoesUp.beans.BoardInfoBean;

import java.util.List;

@Mapper
@Repository
public interface TopMenuMapper {

    List<BoardInfoBean> getTopMenuList() throws Exception ;
}