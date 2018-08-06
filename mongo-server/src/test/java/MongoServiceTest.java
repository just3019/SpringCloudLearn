import org.demon.MongoApplicationTest;
import org.demon.service.MongoService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author demon
 * @version 1.0
 * @date 2018/8/6 14:04
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MongoApplicationTest.class})
public class MongoServiceTest {
    @Autowired
    private MongoService mongoService;
}
