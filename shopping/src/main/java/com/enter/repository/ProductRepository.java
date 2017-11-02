package com.enter.repository;

import com.enter.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 14:23
 */
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findProductByCategoryId(Long categoryId);

    Product getProductById(Long productId);

    Page<Product> findAll(Pageable pageable);

}
