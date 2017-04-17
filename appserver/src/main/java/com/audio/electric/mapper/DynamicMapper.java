package com.audio.electric.mapper;

import com.audio.electric.domain.CookieUser;
import com.audio.electric.domain.User;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/14 0014 13:30
 */
@Component
public interface DynamicMapper {

    List<Map<String,String>> listAttention(CookieUser user) throws SQLException;

    List<Map<String,String>> listRecommendDynamic(CookieUser user) throws SQLException;

    Map<String,String> getPortfolioInfo(Long portfolio_id) throws SQLException;

    List<Map<String,String>> getCommentsById(Long id) throws SQLException;
}
