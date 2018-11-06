package org.demon.springwebfluesamples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author demon
 * @version 1.0
 * @date 2018/11/5 17:06
 * @since 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello !!!";
    }

//    @GetMapping("/hello2")
//    public Mono<String> hello2() {
//        return Mono.just("hello2 !!!");
//    }
}
