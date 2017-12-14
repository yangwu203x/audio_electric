package com.enter.repository;

import com.enter.entity.Property;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/12/1 0007 14:53
 */
public interface PropertyRepository extends Repository<Property,Long>{
     Set<Property> findPropertyByProductIdOrderByNumDesc(Long productId);

     Property findPropertyByProductIdAndColorNo(Long productId,String colorNo);

     Set<Property> findPropertyByIdIn(List<Long> propertyIdList);
}
