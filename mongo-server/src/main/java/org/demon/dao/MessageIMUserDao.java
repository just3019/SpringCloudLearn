package org.demon.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author demon
 * @version 1.0
 * @date 2018/8/6 11:19
 * @since 1.0
 */
public class MessageIMUserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(){


    }

}
