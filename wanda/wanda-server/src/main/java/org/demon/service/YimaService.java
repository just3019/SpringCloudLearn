package org.demon.service;

import cn.hutool.core.util.StrUtil;
import lombok.extern.apachecommons.CommonsLog;
import org.demon.bean.yima.YimaAccount;
import org.demon.bean.yima.YimaLogin;
import org.demon.bean.yima.YimaMobile;
import org.demon.exception.BusinessException;
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
@CommonsLog
public class YimaService {

    private static final String PRE_URL = "http://api.fxhyd.cn/UserInterface.aspx";

    /**
     * 易码登录方法
     *
     * @param yimaLogin {@link YimaLogin}
     */
    public String login(YimaLogin yimaLogin) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(PRE_URL + yimaLogin.getLoginUrl())).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info(response.statusCode() + " " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            log.error("易码登录错误");
        }
        assert response != null;
        return getString(response);
    }

    /**
     * 查询易码账号信息
     *
     * @param yimaAccount {@link YimaAccount}
     */
    public String get(YimaAccount yimaAccount) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(PRE_URL + yimaAccount.getUrl())).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info(response.statusCode() + " " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            log.error("易码账号获取失败");
        }
        assert response != null;
        return getString(response);
    }

    /**
     * 易码获取手机号
     *
     * @param yimaMobile {@link YimaMobile}
     */
    public String getMobile(YimaMobile yimaMobile) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(PRE_URL + yimaMobile.getUrl())).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info(response.statusCode() + " " + response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            log.error("易码获取手机号失败");
        }
        assert response != null;
        return getString(response);
    }


    private String getString(HttpResponse<String> response) {
        assert response != null;
        String[] result = response.body().split("\\|");
        if (StrUtil.equals(result[0], "success")) return result[1];
        throw new BusinessException(-4, response.body());
    }


}
