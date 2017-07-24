package com.audio.electric.template;

import com.audio.electric.domain.TablePage;
import com.mongodb.WriteResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * 基类
 * @Author leo_Yang【音特】
 * @Date 2017/5/19 0019 11:29
 */
public class MongoRepImp<T> {
    private String collection;
    private MongoTemplate mongoTemplate;
    private Class entity;

    public MongoRepImp(Class<T> entity, MongoTemplate mongoTemplate) {
        Document documentName = entity.getAnnotation(Document.class);
        if (documentName != null) {
            this.collection = documentName.collection();
            this.entity = entity;
            this.mongoTemplate = mongoTemplate;
        }
    }

    public T findOne(String id) {
        return (T) this.mongoTemplate.findById(id, this.entity, this.collection);
    }

    public T findOne(Query query) {
        List<T> list = this.mongoTemplate.find(query, this.entity, this.collection);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public List<T> findAll() {
        return this.mongoTemplate.findAll(entity, this.collection);
    }

    public List<T> find(Query query) {
        return this.mongoTemplate.find(query, entity, this.collection);
    }

    public void save(T entity) {
        this.mongoTemplate.save(entity, this.collection);
    }

    /**
     * 批量插入
     * @param entitys
     */
    public void saveAll(List<T> entitys){ this.mongoTemplate.insertAll(entitys);
    }

    public List<T> query(Query query) {
        return this.mongoTemplate.find(query, this.entity, this.collection);
    }

    public WriteResult update(Query query, Update update) {
        return this.mongoTemplate.updateFirst(query, update, this.entity, this.collection);
    }

    /**
     * 批量更新
     * @param query
     * @param update
     * @return
     */
    public WriteResult updateMulti(Query query,Update update){
        return this.mongoTemplate.updateMulti(query, update, this.entity, this.collection);
    }

    public WriteResult upsert(Query query, Update update) {
        return this.mongoTemplate.upsert(query, update, this.entity, this.collection);
    }

    public WriteResult delete(Query query) {
        return this.mongoTemplate.remove(query, this.entity, this.collection);
    }

    public WriteResult delete(String id) {
        return this.mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), this.entity, this.collection);
    }

    public boolean exists(Query query) {
        return this.mongoTemplate.exists(query, this.entity, this.collection);
    }

    public TablePage<T> findAll(Query query, Pageable pageable) {
        query = query.with(pageable);
        long totalCount = this.mongoTemplate.count(query, this.entity, this.collection);
        List<T> list = this.mongoTemplate.find(query, this.entity, this.collection);
        TablePage<T> page = new TablePage<T>(list, totalCount);
        return page;
    }
}
