package org.demon.service;

import org.demon.bean.PageData;
import org.demon.bean.wanda.PhoneBean;
import org.demon.bean.wanda.PhoneQuery;
import org.demon.exception.BusinessException;
import org.demon.mapper.PhoneMapper;
import org.demon.mapper.WandaUserMapper;
import org.demon.pojo.Phone;
import org.demon.pojo.PhoneExample;
import org.demon.pojo.WandaUser;
import org.demon.util.FunctionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * desc:
 *
 * @author demon
 * @date 2018-11-24 00:27
 */
@Service
public class PhoneService {

    @Autowired
    private PhoneMapper phoneMapper;
    @Autowired
    private WandaUserMapper wandaUserMapper;


    /**
     * 保存phone
     *
     * @param bean {@link PhoneBean}
     * @return {@link Phone}
     */
    public Phone save(PhoneBean bean) {
        Phone phone = convert2Phone(bean);
        FunctionUtil.check(phoneMapper.insertSelective(phone) <= 0, new BusinessException(-5, "保存phone失败"));
        WandaUser user = new WandaUser();
        user.setMemberId(bean.memberId);
        user.setPhone(bean.phone);
        user.setPlaceId(bean.placeId);
        user.setActivated(false);
        user.setRegDate(System.currentTimeMillis());
        FunctionUtil.check(wandaUserMapper.insertSelective(user) <= 0, new BusinessException(-9, "保存wanda_user失败"));
        return phone;
    }

    /**
     * bean -> pojo
     *
     * @param bean {@link PhoneBean}
     * @return {@link Phone}
     */
    private Phone convert2Phone(PhoneBean bean) {
        Phone phone = new Phone();
        phone.setMemberId(bean.memberId);
        phone.setPhone(bean.phone);
        phone.setPlaceId(bean.placeId);
        phone.setToken(bean.token);
        return phone;
    }


    /**
     * 查询列表
     *
     * @param query {@link PhoneQuery}
     * @return {@link PageData} {@link PhoneBean}
     */
    public PageData<PhoneBean> select(PhoneQuery query) {
        PageData<PhoneBean> pageData = new PageData<>();
        PhoneExample example = new PhoneExample();
        PhoneExample.Criteria criteria = example.createCriteria();
        FunctionUtil.whenNonNullDo(criteria::andPhoneEqualTo, query.phone);
        FunctionUtil.whenNonNullDo(criteria::andPlaceIdEqualTo, query.placeId);
        if ((pageData.count = phoneMapper.countByExample(example)) == 0L) {
            return pageData;
        }
        example.setLimit(query.getLimit());
        example.setOffset(query.getOffset());
        List<Phone> phones = Optional.ofNullable(phoneMapper.selectByExample(example)).orElseGet(ArrayList::new);
        pageData.list = phones.stream().map(this::convert2Bean).collect(Collectors.toList());
        return pageData;
    }

    /**
     * pojo-> bean
     *
     * @param phone {@link Phone}
     * @return {@link PhoneBean}
     */
    private PhoneBean convert2Bean(Phone phone) {
        PhoneBean bean = new PhoneBean();
        bean.memberId = phone.getMemberId();
        bean.phone = phone.getPhone();
        bean.placeId = phone.getPlaceId();
        bean.token = phone.getToken();
        return bean;
    }
}
