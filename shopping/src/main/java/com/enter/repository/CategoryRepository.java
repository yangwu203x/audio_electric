package com.enter.repository;

import com.enter.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/13 0013 17:20
 */
@Component
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category save(Category category);
}
