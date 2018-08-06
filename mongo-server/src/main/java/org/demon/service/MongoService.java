package org.demon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * 1.往mongodb存储单条数据
 * save(Object object)
 * <p>
 * 2.往mongodb存储数据列表
 * saveBatch(Object)
 * <p>
 * 3.更新mongodb数据
 *
 * @author demon
 * @version 1.0
 * @date 2018/8/6 14:03
 * @since 1.0
 */
@Service
@ConditionalOnClass(MongoTemplate.class)
public class MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Object objectToSave) {
        mongoTemplate.save(objectToSave);
    }



}
