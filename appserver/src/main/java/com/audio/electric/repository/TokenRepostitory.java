package com.audio.electric.repository;

import com.audio.electric.domain.Token;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/18 0018 16:33
 */
@Repository
public interface TokenRepostitory extends MongoRepository<Token,String> {

}
