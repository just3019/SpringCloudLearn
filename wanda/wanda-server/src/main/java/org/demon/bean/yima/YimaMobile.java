package org.demon.bean.yima;

import cn.hutool.core.util.StrUtil;

/**
 * desc:
 *
 * @author demon
 * @date 2018-11-19 17:10
 */
public class YimaMobile {

    public String token;
    public String itemid;
    public String isp;
    public String province;
    public String city;
    public String mobile;
    public String excludeno;

    public String getUrl() {
        return StrUtil.format("?action=getmobile&token={}&itemid={}&isp={}&province={}&city={}&excludeno={}", token, itemid, isp, province, city, mobile, excludeno);
    }
}
