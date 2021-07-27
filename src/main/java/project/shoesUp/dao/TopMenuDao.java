package project.shoesUp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.shoesUp.beans.BoardInfoBean;
import project.shoesUp.mapper.TopMenuMapper;

import java.util.List;

@Repository
public class TopMenuDao {

    @Autowired
    private TopMenuMapper topMenuMapper;

    public List<BoardInfoBean> getTopMenuList(){
        List<BoardInfoBean> topMenuList = topMenuMapper.getTopMenuList();
        return topMenuList;
    }


}
