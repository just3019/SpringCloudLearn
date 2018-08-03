import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import org.junit.Test;

/**
 * @author demon
 * @version 1.0
 * @date 2018/8/3 16:23
 * @since 1.0
 */
public class JavaTest {

    @Test
    public void insert() {
        Mongo connection = new Mongo();
        DB db = connection.getDB("test1");
        DBCollection ts = db.getCollection("t");
        DBObject t = new BasicDBObject();
        t.put("name", "demon");
        DBObject tdown = new BasicDBObject();
        tdown.put("city", "bj");
        t.put("tdown", tdown);
        ts.insert(t);

        DBObject dbTest = ts.findOne();
        System.out.println(dbTest);
        System.out.println(dbTest.get("tdown"));
    }
}
