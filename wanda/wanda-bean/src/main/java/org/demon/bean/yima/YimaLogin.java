package org.demon.bean.yima;

import lombok.NonNull;

/**
 * desc: 易码登录对象
 *
 * @author demon
 * @date 2018-11-13 16:36
 */
public class YimaLogin {
    @NonNull
    public String username;
    @NonNull
    public String password;

    /**
     * 获取易码登录参数
     */
    public String getLoginUrl() {
        return "?action=login&username=" + username + "&password=" + password;
    }

}
