package com.example.demo.controller;

import com.example.demo.dao.NumberDao;
import com.example.demo.util.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.util.Count.addCount;

@RestController
public class NumberController {

    @Autowired
    NumberDao numberDao;

    @RequestMapping("/number")
    public String getNumber(@RequestParam(name = "ip", required = true) String ip) {
        long id = addCount(ip);
        if (id == 0) {
            try {
                numberDao.addId(ip);
            } catch (Exception e) {
                //e.printStackTrace();
            }
            System.out.println(numberDao.getId());
            Count.putValue(ip, Integer.parseInt(numberDao.getId()));
            return String.valueOf(Count.concurrentHashMap.get(ip));
        } else if (id == 1) {
            try {
                numberDao.addId(ip);
            } catch (Exception e) {
                //e.printStackTrace();
            }
            Count.putValue(ip, Integer.parseInt(numberDao.getId()));
            return String.valueOf(addCount(ip));
        } else {
            return String.valueOf(id);
        }
    }

}
