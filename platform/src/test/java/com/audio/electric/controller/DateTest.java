package com.audio.electric.controller;

import java.util.GregorianCalendar;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/10 0010 19:15
 */
public class DateTest
{
    public static void main(String[] args){
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(1993,7,12);
        long birthday = gc.getTimeInMillis();
        long now = new GregorianCalendar().getTimeInMillis();
        System.out.println((now-birthday)/(1000*60*60*24));
        System.out.println(now/(1000*60*60*24));//从格林威治时间到现在的天数


        GregorianCalendar gc1 = new GregorianCalendar();
        gc.set(1924,1,1);
        System.out.println(gc1.getTimeInMillis()/(1000*60*60*24));//从格林威治时间到现在的天数


        System.out.println(System.currentTimeMillis()/(1000*60*60*24));
    }
}
