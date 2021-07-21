package project.shoesUp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import project.demo.beans.BoardInfoBean;

import java.util.List;

@Mapper
@Repository
public interface TopMenuMapper {

    @Select("SELECT board_info_idx, board_info_name" +
            "FROM  board_info_table" +
            "ORDER BY board_info_idx")
    List<BoardInfoBean> getTopMenuList();
}