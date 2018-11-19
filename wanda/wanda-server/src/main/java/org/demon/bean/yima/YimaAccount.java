package org.demon.bean.yima;

/**
 * desc:查询易码用户对象
 *
 * @author demon
 * @date 2018-11-13 17:48
 */
public class YimaAccount {
    public String token;


    public String getUrl() {
        return "?action=getaccountinfo&token=" + token + "&format=1";
    }
}
