package com.enter.repository;

import com.enter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/13 0013 17:20
 */
@Component
public interface UserRepository extends JpaRepository<User,Long> {
    User getUserById(Long id);

    User getUserByEmail(String email);

    User getUserByEmailAndPassword(String email,String password);

    User save(User user);
}
