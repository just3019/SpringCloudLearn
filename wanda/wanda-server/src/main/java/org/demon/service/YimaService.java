package org.demon.service;

import lombok.extern.log4j.Log4j2;
import org.demon.bean.yima.YimaAccount;
import org.demon.bean.yima.YimaLogin;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * desc: 添加易码业务
 *
 * @author demon
 * @date 2018-11-13 16:33
 */
@Service
@Log4j2
public class YimaService {

    private static final String PRE_URL = "http://api.fxhyd.cn/UserInterface.aspx";

    /**
     * 易码登录方法
     *
     * @param yimaLogin {@link YimaLogin}
     */
    public void login(YimaLogin yimaLogin) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(PRE_URL + yimaLogin.getLoginUrl())).build();
        HttpResponse response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info(response.statusCode() + " " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            log.error("易码登录错误");
        }
    }

    public void get(YimaAccount yimaAccount){

    }

}
