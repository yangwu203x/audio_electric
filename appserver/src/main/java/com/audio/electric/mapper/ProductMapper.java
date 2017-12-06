package com.audio.electric.mapper;

import com.audio.electric.domain.Product;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/29 0029 15:19
 */
@Component
public interface ProductMapper {

    Product getExpiryDateBySerialNo(String serialNo) throws SQLException;
}
