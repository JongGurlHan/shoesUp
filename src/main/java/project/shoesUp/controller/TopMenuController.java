package project.shoesUp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopMenuController {

    @Autowired
    TestUserService testUserService;

    @GetMapping("/board/freeBoard")
    private void getTopMenuList() throws Exception {
        List<BoardInfoBean>topMenuList = testUserService.getUserList();

        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }
    }

}
//    @Autowired
//    private TopMenuDao topMenuDao;
//
//    public List<BoardInfoBean> getTopMenuList(){
//        List<BoardInfoBean> topMenuList = topMenuDao.getTopMenuList();
//        return topMenuList;
//    }