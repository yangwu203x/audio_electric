package com.audio.electric;

import com.audio.electric.controller.LoginController;
import com.audio.electric.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppserverApplicationTests {

	@Autowired
	LoginController loginController;

	//登录
	@Before
	public void login(){
		User user = new User();
		user.setUsername("125667528@qq.com");
		user.setPassword("123456");
		try {
			loginController.login(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void contextLoads() {
	}

}
