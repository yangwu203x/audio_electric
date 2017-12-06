package com.enter.service.impl;

import com.enter.entity.Banner;
import com.enter.entity.Product;
import com.enter.entity.Property;
import com.enter.repository.PropertyRepository;
import com.enter.repository.ProductRepository;
import com.enter.service.IBannerService;
import com.enter.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 14:22
 */
@Component
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private IBannerService bannerService;
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Product> findProductByCategoryId(Integer categoryId) {
        List<Product> product =  productRepository.findProductByCategoryId(categoryId);
        return product;
    }

    @Override
    public Product findOne(Long productId) {
        Product product = productRepository.findOne(productId);
        Set<Property> propertySet = propertyRepository.findPropertyByProductId(productId);
        product.setPropertySet(propertySet);
        return product;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Map<String, Object> listMall() {
        Map<String, Object> map = new HashMap<>();
        //广告图
        List<Product> products = productRepository.findAll();
        //智能麦克风点歌机系列
        List<Product> micProducts = new ArrayList<>();
        Iterator<Product> it = products.iterator();
        while (it.hasNext()){
            Product product = it.next();
            switch (product.getCategoryId()){
                case 1:
                    if (product.getPosition() == 5){
                        map.put("firstProduct",product);
                    }else if (product.getPosition() == 1){
                        map.put("secondProduct",product);
                    }else if (product.getPosition() == 2){
                        micProducts.add(product);
                    }else if (product.getPosition() == 3){
                        micProducts.add(product);
                    }
                    it.remove();
                    break;
                case 2:
                    map.put("bluetooth",product);
                    it.remove();
                    break;
                case 3:
                    map.put("professional",product);
                    it.remove();

                    break;
                case 4:
                    map.put("tvBox",product);
                    it.remove();
                    break;
                case 5:
                    map.put("kBan",product);
                    it.remove();
                    break;
                default:
                    //不做处理
            }
        }
        List<Banner> banners = bannerService.findBannerByCategory("product");
        map.put("banners",banners);
        map.put("micProducts",micProducts);
        return map;
    }

    @Override
    public List<Product> findProductByPosition(int position) {
        return productRepository.findProductByPosition(position);
    }
}
