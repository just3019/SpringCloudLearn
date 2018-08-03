package org.demon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-hi")
public interface HiClient {

    @RequestMapping("/hi")
    String home(@RequestParam(value = "name", defaultValue = "hi") String name);
}
