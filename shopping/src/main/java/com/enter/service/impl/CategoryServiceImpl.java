package com.enter.service.impl;

import com.enter.entity.Category;
import com.enter.repository.CategoryRepository;
import com.enter.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/20 0020 16:41
 */
@Transactional
@Component
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
