package com.enter.repository;

import com.enter.entity.Product;
import com.enter.entity.Trolley;
import com.enter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/13 0013 17:20
 */
@Component
public interface TrolleyRepository extends JpaRepository<Trolley,Long> {

    List<Trolley> findTrolleyByIdInAndUserIdAndStatus(List<Long> trolleyIds,Long userId,Integer status);



    List<Trolley> findTrolleyByIdInAndUserIdAndStatusIn(List<Long> trolleyIds,Long userId,List<Integer> statusList);

    List<Trolley> findTrolleyByUserIdAndStatusIn(Long userId,List<Integer> statusList);

    List<Trolley> findTrolleyByUserIdAndStatusIn(long id,List<Integer> statusList);

    Trolley findTrolleyByUserAndProductAndStatus(User user,Product product,Integer status);

    /**
     * 查询个人购物车商品数量
     * @param user
     * @return
     */
    @Query("select sum(t.count) from Trolley t where t.user=:user and t.status in (0,1)")
    String getTrolleyNum(@Param("user") User user);

    Trolley findTrolleyByUserIdAndProductAndStatusIn(Long userId,Product product,List<Integer> statusList);

    Set<Trolley> findTrolleyByIdInAndStatusIn(List<Long> trolleyList, List<Integer> status);

    @Modifying
    @Query("delete from Trolley t where t.id =:trolleyId and t.user=:user")
    int deleteTrolleyByIdAndUser(@Param("trolleyId") Long id,@Param("user") User user);

}
