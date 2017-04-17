package com.audio.electric;

import com.audio.electric.domain.City;
import com.github.pagehelper.PageHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppserverApplicationTests {

	@Autowired
	private CityService cityService;

	@Test
	public void contextLoads() {
		PageHelper.startPage(1,2);
		List<City> list = cityService.select();
		for (City city: list)
			System.out.println(city);
		Assert.assertEquals(2,list.size());
	}

}
