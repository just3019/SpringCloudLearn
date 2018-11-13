package org.demon.service;

import org.demon.ApplicationLaunch;
import org.demon.bean.yima.YimaLogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * desc:
 *
 * @author demon
 * @date 2018-11-13 17:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationLaunch.class})
public class YimaServiceTest {

    private static final String USERNAME = "chongzhou";
    private static final String PASSWORD = "chongzhou";

    @Autowired
    private YimaService yimaService;

    @Test
    public void test_1() {
        YimaLogin yimaLogin = new YimaLogin();
        yimaLogin.username = USERNAME;
        yimaLogin.password = PASSWORD;
        yimaService.login(yimaLogin);
    }
}
