package org.demon.service;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.util.StrUtil;
import org.demon.exception.BusinessException;
import org.demon.mapper.ClientCodeMapper;
import org.demon.pojo.ClientCode;
import org.demon.pojo.ClientCodeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientCodeService {

    @Autowired
    private ClientCodeMapper clientCodeMapper;


    /**
     * 验证序列号
     *
     * @param no 序列号
     */
    public void check(String no) {
        ClientCodeExample example = new ClientCodeExample();
        example.createCriteria().andNoEqualTo(no).andFailtimeGreaterThan(new Date());
        List<ClientCode> clientCodes = clientCodeMapper.selectByExample(example);
        if (IterUtil.isEmpty(clientCodes)) {
            throw new BusinessException(-3, "该客户端已失效");
        }
    }
}