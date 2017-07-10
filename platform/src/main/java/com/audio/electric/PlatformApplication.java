package com.audio.electric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.audio.electric.util.listener")
public class PlatformApplication
{
	public static void main(String[] args) {
		SpringApplication.run(PlatformApplication.class, args);
	}
}
