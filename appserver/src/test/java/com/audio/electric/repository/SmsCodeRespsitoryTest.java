package com.audio.electric.repository;


//import com.audio.electric.AppserverApplication;
//import com.audio.electric.domain.SmsCode;
//import com.audio.electric.util.tool.DateStyle;
//import com.audio.electric.util.tool.DateUtil;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/17 0017 18:13
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(AppserverApplication.class)
public class SmsCodeRespsitoryTest {

//    @Autowired
//    private SmsCodeRespsitory smsCodeRespsitory;
//
//    @Test
//    public void test(){
//        smsCodeRespsitory.deleteAll();
//        SmsCode smsCode = new SmsCode();
//        smsCode.setSendMessage("在干嘛啊？");
//        smsCode.setPhone("13092796646");
//        smsCode.setId(1l);
//        SmsCode smsCode2 = new SmsCode();
//        smsCode2.setSendMessage("在吃饭啊");
//        smsCode2.setPhone("18680324716");
//        smsCode2.setId(2l);
//        smsCode.setSendTime(DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS_CN.getValue()));
//        smsCodeRespsitory.save(smsCode);
//        smsCodeRespsitory.save(smsCode2);
//        smsCode.setSendMessage("还不回家！");
//        Assert.assertEquals("还不回家！",smsCodeRespsitory.findOne(1l).getSendMessage());
//        Assert.assertEquals(2,smsCodeRespsitory.findAll().size());
//        //修改
//        smsCodeRespsitory.delete(1l);
//        Assert.assertEquals(1,smsCodeRespsitory.findAll().size());
//        SmsCode smsCode3 = smsCodeRespsitory.findOne(2l);
//        Assert.assertEquals("18680324716",smsCodeRespsitory.findOne(2l).getPhone());
//    }
}