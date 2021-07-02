package project.shoesUp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.shoesUp.dao.TestDao;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public String testMethod(){

        String str = testDao.testDaoMethod();
        return str;
    }
}
