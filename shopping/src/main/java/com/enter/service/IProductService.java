package com.enter.service;

import com.enter.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 17:34
 */
public interface IProductService {
    List<Product> findProductByCategoryId(Integer categoryId);

    Product findOne(Long productId);

    Page<Product> findAll(Pageable pageable);


    Map<String,Object> listMall();

    List<Product> findProductByPosition(int position);
}
