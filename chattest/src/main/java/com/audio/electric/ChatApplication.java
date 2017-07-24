package com.audio.electric;

import com.audio.electric.service.MessageService;
import com.audio.electric.util.ApplicationContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ServletComponentScan("ice.listener")
public class ChatApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ChatApplication.class, args);
		ApplicationContextUtil.setApplicationContext(applicationContext);
	}
}
