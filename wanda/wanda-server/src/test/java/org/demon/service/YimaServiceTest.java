package org.demon.service;

import org.demon.ApplicationLaunch;
import org.demon.bean.yima.YimaAccount;
import org.demon.bean.yima.YimaLogin;
import org.demon.bean.yima.YimaMobile;
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
        System.out.println("获取易码token：" + yimaService.login(yimaLogin));
    }

    @Test
    public void test_2() {
        YimaAccount yimaAccount = new YimaAccount();
        yimaAccount.token = "00737301489048957a6cdba66f365cca50a3d7d88601";
        System.out.println("获取易码用户信息：" + yimaService.get(yimaAccount));
    }

    @Test
    public void test_3() {
        YimaMobile yimaMobile = new YimaMobile();
        yimaMobile.itemid = "27894";
        yimaMobile.token = "00737301489048957a6cdba66f365cca50a3d7d88601";
        System.out.println("获取易码号码：" + yimaService.getMobile(yimaMobile));
    }

}
