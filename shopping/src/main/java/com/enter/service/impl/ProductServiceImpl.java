package com.enter.service.impl;

import com.enter.entity.Product;
import com.enter.repository.ProductRepository;
import com.enter.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 14:22
 */
@Component
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findProductByCategoryId(Long categoryId) {
        List<Product> product =  productRepository.findProductByCategoryId(categoryId);
        return product;
    }

    @Override
    public Product findOne(Long productId) {

        return productRepository.findOne(productId);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
