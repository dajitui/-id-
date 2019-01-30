package com.example.demo;

import com.example.demo.dao.NumberDao;
import com.example.demo.util.Count;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.demo.util.Count.addCount;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    NumberDao numberDao;

    @Test
    public void contextLoads() {
        /*new Count(2);
        System.out.println(addCount());*/
    }

    @Test
    public void test() {
        try {
            numberDao.addId("123");
        } catch (Exception e) {
            //e.printStackTrace();
        }

        System.out.println(numberDao.getId());
    }

}

