package org.demon.controller;

import cn.hutool.core.util.StrUtil;
import org.demon.exception.BusinessException;
import org.demon.service.WandaUserService;
import org.demon.util.FunctionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc:
 *
 * @author demon
 * @date 2018-11-28 14:11
 */
@RestController
public class WandaUserController {

    @Autowired
    private WandaUserService wandaUserService;


    /**
     * 查询手机号是否存在
     *
     * @param phone 手机号
     * @return
     */
    @GetMapping(value = "/wandaUser/exist/{phone}")
    public boolean exist(@PathVariable("phone") String phone) {
        FunctionUtil.check(StrUtil.isEmpty(phone), new BusinessException(-7, "传入手机号"));
        wandaUserService.selectByPhone(phone);
        return true;
    }

    @GetMapping(value = "/wandaUser/clean")
    public void clean(){
        wandaUserService.clean();
    }
}
