package org.demon.controller;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.demon.bean.DemoBean;
import org.demon.bean.PageData;
import org.demon.exception.BusinessException;
import org.demon.mapper.DemoMapper;
import org.demon.pojo.Demo;
import org.demon.pojo.DemoExample;
import org.demon.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/17 14:34
 * @since 1.0
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private DemoMapper demoMapper;

    @GetMapping(value = "/demo/{id}")
    public Demo get(@PathVariable("id") Long id) {
        return demoMapper.selectByPrimaryKey(id);
    }

    @PostMapping(value = "/demos")
    public PageData<Demo> list(@RequestBody DemoBean bean) {
        PageData<Demo> pageData = new PageData<>();
        DemoExample example = new DemoExample();
        DemoExample.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotEmpty(bean.name)) {
            criteria.andNameLike(bean.name);
        }
        pageData.count = demoMapper.countByExample(example);
        example.setLimit(bean.getLimit());
        example.setOffset(bean.getOffset());
        pageData.list = demoMapper.selectByExample(example);
        return pageData;
    }

    @GetMapping(value = "/demo/testBusinessException")
    public void testBusinessException() {
        throw new BusinessException(-2, "错误");
    }

    @GetMapping(value = "/demo/testOtherException")
    public void testOtherException() throws IOException {
        throw new IOException("io错误");
    }

    @GetMapping(value = "/demo/testMemoryException")
    public void testMemoryException() {
        throw new OutOfMemoryError("内存溢出");
    }
}
