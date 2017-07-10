package com.audio.electric.service.impl;

import java.net.InetAddress;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/15 0015 14:32
 */
public class Test {
    public static void main(String[] args) {
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
