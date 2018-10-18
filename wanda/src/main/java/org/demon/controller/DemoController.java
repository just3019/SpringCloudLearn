package org.demon.controller;

import org.demon.exception.BusinessException;
import org.demon.mapper.DemoMapper;
import org.demon.pojo.Demo;
import org.demon.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
