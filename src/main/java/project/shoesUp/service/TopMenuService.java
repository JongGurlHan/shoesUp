package project.shoesUp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.shoesUp.beans.BoardInfoBean;
import project.shoesUp.mapper.TopMenuMapper;

import java.util.List;

@Service
public class TopMenuService {

    @Autowired
    TopMenuMapper topMenuMapper;

    public List<BoardInfoBean> getTop

}
