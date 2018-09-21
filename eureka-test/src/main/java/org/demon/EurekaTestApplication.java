package org.demon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@EnableCircuitBreaker
public class EurekaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaTestApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "demon") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping("/test")
    @HystrixCommand(fallbackMethod = "hasError")
    public String test() throws Exception {
        throw new Exception("hall");
    }

    public String hasError() {
        return "error!!!";
    }

    @Autowired
    private HiClient hiClient;

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable("name") String name) {
        return hiClient.home(name);
    }
}
