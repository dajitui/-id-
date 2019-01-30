package com.example.demo.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Count {
    private static AtomicLong atomicLong;

    public static ConcurrentHashMap<String,AtomicLong> concurrentHashMap=new ConcurrentHashMap();

    //储存号段里面最大值
    private static ConcurrentHashMap<String,String> currentMaxId=new ConcurrentHashMap();

    public Count(String ip,long number){
        /**
         * 拿到一个号段之后乘以100，也就是拿到100个id
         * 比如拿到1，id是从100，到199之间.
         */
        this.atomicLong=new AtomicLong(number*100);
        number=number*100+99;
        currentMaxId.put(ip,String.valueOf(number));
        concurrentHashMap.put(ip,atomicLong);
    }

    public static long addCount(String ip){
        if(concurrentHashMap.get(ip)==null){
            System.out.println("AtomicLong还没有拿到号段");
            return 0;
        }else{
            int i=Integer.valueOf(currentMaxId.get(ip));
            if(concurrentHashMap.get(ip).get()==i){
                System.out.println("号段的id已经超过100，重新获取号段");
                return 1;
            }
        }
        return concurrentHashMap.get(ip).incrementAndGet();
    }

    public static void putValue(String ip, long number){
        new Count(ip,number);
    }
}
