package project.service;

import org.springframework.stereotype.Service;

@Service
public class TopMenuService {

    @Autowired
    private TopMenuDao topMenuDao;

    public List<BoardInfoBean> getTopMenuList(){
        List<BoardInfoBean> topMenuList = topMenuDao.getTopMenuList();
        return topMenuList;Z
    }
}
