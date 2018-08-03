package org.demon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author demon
 * @version 1.0
 * @date 2018/8/2 09:45
 * @since 1.0
 */
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }



    @Bean
    public ZuulRequestFilter zuulRequestFilter() {
        return new ZuulRequestFilter();
    }
}
