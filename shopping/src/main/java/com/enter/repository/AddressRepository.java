package com.enter.repository;

import com.enter.entity.Address;
import com.enter.entity.User;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 14:56
 */
public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findAddressByUserId(Long userId);

    Address findAddressByUserAndSelected(User user, Integer selected);

    Address findAddressByUserAndId(User user, Long id);
}
