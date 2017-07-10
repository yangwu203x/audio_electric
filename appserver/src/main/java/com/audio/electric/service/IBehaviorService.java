package com.audio.electric.service;

import com.audio.electric.domain.FeedBack;
import com.audio.electric.domain.PortfolioComments;
import com.audio.electric.domain.Shield;
import com.audio.electric.domain.SongLack;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:16
 */
public interface IBehaviorService{
    int attention(String be_user_id, String type);

    int goods(String type,String portfolio_id);

    int collection(String type,String portfolio_id);

    int givingGift(String portfolio_id,String type,int amount);

    int saveSongLack(SongLack songLack);

    int saveFeedback(FeedBack feedBack);

    int comments(PortfolioComments portfolioComments);

    int shield(Shield shield);
}
