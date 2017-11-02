package com.enter.shopping;

import com.enter.entity.*;
import com.enter.service.ICategoryService;
import com.enter.service.IOrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 18:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void saveCategoryService(){
        Category category = new Category();
        category.setName("家庭ktv");
        category.setsId(0l);
        Category category2 = new Category();
        category2.setName("商用ktv");
        category2.setsId(0l);
        categoryService.save(category);
        categoryService.save(category2);
    }

}
