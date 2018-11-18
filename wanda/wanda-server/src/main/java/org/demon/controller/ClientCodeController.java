package org.demon.controller;

import org.demon.service.ClientCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户端接口
 */
@RestController
public class ClientCodeController {

    @Autowired
    private ClientCodeService clientCodeService;


    @GetMapping(value = "/check/{no}")
    public void check(@PathVariable("no") String no) {
        clientCodeService.check(no);

    }

}
