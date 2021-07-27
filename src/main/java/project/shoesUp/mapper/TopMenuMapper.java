package project.shoesUp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import project.shoesUp.beans.BoardInfoBean;
import project.shoesUp.service.TopMenuService;

import java.util.List;

@Mapper
public interface TopMenuMapper {

    @Select("SELECT board_info_idx, board_info_name FROM board_info_table")
    List<BoardInfoBean>getTopMenuList();
}