package org.demon.controller;

import org.demon.bean.PageData;
import org.demon.bean.wanda.PhoneBean;
import org.demon.bean.wanda.PhoneQuery;
import org.demon.exception.BusinessException;
import org.demon.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc:
 *
 * @author demon
 * @date 2018-11-24 00:24
 */
@RestController
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping(value = "/phone")
    public void save(@RequestBody PhoneBean bean) {
        phoneService.save(bean);
    }

    /**
     * 查询列表
     *
     * @param query {@link PhoneQuery}
     * @return {@link PageData} {@link PhoneBean}
     */
    @PostMapping(value = "/phones")
    public PageData<PhoneBean> list(@RequestBody PhoneQuery query) {
        if (query.phone == null && query.placeId == null) {
            throw new BusinessException(-6, "需要传参");
        }
        return phoneService.select(query);
    }

}
