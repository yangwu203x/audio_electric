package com.enter.repository;

import com.enter.entity.Product;
import com.enter.entity.Trolley;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

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

    Trolley findTrolleyByUserIdAndProductAndStatusIn(Long userId,Product product,List<Integer> statusList);

    List<Trolley> findTrolleyByIdInAndStatusIn(List<Long> trolleyList,List<Integer> status);

}
