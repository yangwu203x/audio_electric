package com.audio.electric.mapper;

import com.audio.electric.domain.Product;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/6 0006 16:31
 */
@Component
public interface UpdateMapper {

    Product getExpiryDate(String mac);
}
