import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author demon
 * @version 1.0
 * @date 2018/8/3 16:23
 * @since 1.0
 */
public class JavaTest {

    @Test
    public void insert() {
        MongoClient mongoClient = new MongoClient("localhost");
        DB db = mongoClient.getDB("test");
        DBCollection collection = db.getCollection("message_user");

        long uid = 1;
        List<DBObject> objects = new ArrayList<>();
        long start = System.currentTimeMillis();
        String message_no = StringUtil.getRandomLetter(8);
        for (int i = 0; i < 1000000; i++) {
            uid += 1;
            BasicDBObject obj = new BasicDBObject();
            obj.put("message_no", message_no);
            obj.put("uid", uid);
            obj.put("receive", NumberUtil.getRandomInValue(2));
            obj.put("open", NumberUtil.getRandomInValue(2));
            objects.add(obj);
        }
        long end = System.currentTimeMillis();
        WriteResult result = collection.insert(objects);
        System.out.println(result.toString());
        long end1 = System.currentTimeMillis();
        System.out.println("拼数据：" + (end - start) + " 插入：" + (end1 - end));
    }

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            System.out.println(NumberUtil.getRandomInValue(2));
        }
    }


    public class MessageUser {
        private String messageNo;
        private Long uid;
        private Integer receive = 0;
        private Integer open = 0;

        public String getMessageNo() {
            return messageNo;
        }

        public void setMessageNo(String messageNo) {
            this.messageNo = messageNo;
        }

        public Long getUid() {
            return uid;
        }

        public void setUid(Long uid) {
            this.uid = uid;
        }

        public Integer getReceive() {
            return receive;
        }

        public void setReceive(Integer receive) {
            this.receive = receive;
        }

        public Integer getOpen() {
            return open;
        }

        public void setOpen(Integer open) {
            this.open = open;
        }
    }
}
