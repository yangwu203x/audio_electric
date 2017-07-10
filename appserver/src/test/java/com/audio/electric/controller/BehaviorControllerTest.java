package com.audio.electric.controller;

import com.audio.electric.AppserverApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/20 0020 15:43
 */
public class BehaviorControllerTest extends AppserverApplicationTests{
    @Autowired
    BehaviorController behaviorController;
    @Test
    public void attention() throws Exception {
        String be_user_id = "2";
        String type = "0";
        System.out.println(behaviorController.attention(be_user_id,type));
    }


    @Test
    public void goods() throws Exception {
        String portfolio_id = "1";
        String type = "0";
        System.out.println(behaviorController.goods(portfolio_id,type));
       ;
    }

    @Test
    public void collection() throws Exception {
        String portfolio_id = "1";
        String type = "0";
        System.out.println(behaviorController.collection(portfolio_id,type));
    }

    @Test
    public void sendGift() throws Exception {
        String portfolio_id = "1";
        String gift_id = "1" ;
        int amount =20;
        System.out.println(behaviorController.sendGift(portfolio_id,gift_id,amount));
    }

}