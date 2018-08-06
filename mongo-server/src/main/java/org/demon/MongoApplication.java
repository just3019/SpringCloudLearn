package org.demon;

import org.demon.pojo.MessageIMUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author demon
 * @version 1.0
 * @date 2018/8/3 16:04
 * @since 1.0
 */
@SpringBootApplication
@RestController
public class MongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("save")
    public void save() {
        MessageIMUser messageIMUser = new MessageIMUser();
        messageIMUser.setId(1L);
        messageIMUser.setMessageNo("aksdjf");
        save(messageIMUser);
        List<MessageIMUser> list = mongoTemplate.findAll(MessageIMUser.class);
        System.out.println(list);
    }

    @GetMapping("saveBatch")
    public void saveBatch() {
        List<MessageIMUser> messageIMUsers = new ArrayList<>();
        for (long i = 0; i < 1000000; i++) {
            MessageIMUser messageIMUser = new MessageIMUser();
            messageIMUser.setId(i);
            messageIMUser.setMessageNo("aksdjf");
            messageIMUser.setReceive(new Random().nextBoolean());
            messageIMUser.setOpen(new Random().nextBoolean());
            messageIMUsers.add(messageIMUser);
        }
        mongoTemplate.insertAll(messageIMUsers);

    }

    @GetMapping("getAll")
    public List<MessageIMUser> get() {
        Query query = new Query();
        query.limit(100);
        query.skip(600000);
        return mongoTemplate.find(query, MessageIMUser.class);
    }

    @GetMapping("update")
    public void update() {
        MessageIMUser messageIMUser = new MessageIMUser();
        messageIMUser.setId(1L);
        messageIMUser.setMessageNo("aksdjf");
        messageIMUser.setReceive(new Random().nextBoolean());
        messageIMUser.setOpen(new Random().nextBoolean());
        mongoTemplate.updateMulti(new Query(), new Update(), MessageIMUser.class);
    }

    @GetMapping("updateById")
    public void updateById() {
        MessageIMUser messageIMUser = new MessageIMUser();
        messageIMUser.setId(2L);
        messageIMUser.setMessageNo("aksdjf");
        messageIMUser.setReceive(new Random().nextBoolean());
        messageIMUser.setOpen(new Random().nextBoolean());
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(messageIMUser.getId()));
        Update update = new Update().set("messageNo", "aaaa");
        mongoTemplate.updateMulti(query, update, MessageIMUser.class);
    }

    /**
     * 保存对象到
     * 1.save(Object obj)
     */
    public void save(MessageIMUser messageIMUser) {
        mongoTemplate.save(messageIMUser);
    }


    public Query createQuery() {

        return null;
    }

    public Update createUpdate() {
        return null;
    }

}
