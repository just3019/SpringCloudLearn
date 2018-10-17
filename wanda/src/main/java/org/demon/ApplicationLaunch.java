package org.demon;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/17 08:50
 * @since 1.0
 */
@SpringCloudApplication
public class ApplicationLaunch {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationLaunch.class, args);
    }

}
