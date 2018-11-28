package org.demon.service;

import org.demon.exception.BusinessException;
import org.demon.mapper.WandaUserMapper;
import org.demon.pojo.WandaUser;
import org.demon.pojo.WandaUserExample;
import org.demon.util.FunctionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * desc:
 *
 * @author demon
 * @date 2018-11-28 14:12
 */
@Service
public class WandaUserService {

    @Autowired
    private WandaUserMapper wandaUserMapper;

    /**
     * 根据手机号查询
     *
     * @param phone 手机号
     * @return {@link WandaUser}
     */
    public WandaUser selectByPhone(String phone) {
        WandaUserExample example = new WandaUserExample();
        example.createCriteria().andPhoneEqualTo(phone);
        List<WandaUser> list = Optional.ofNullable(wandaUserMapper.selectByExample(example)).orElseGet(ArrayList::new);
        FunctionUtil.check(list.size() <= 0, new BusinessException(-8, "未找到该手机号"));
        return list.get(0);
    }

}
