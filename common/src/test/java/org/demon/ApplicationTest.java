package org.demon;

import org.demon.exception.BusinessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/18 11:28
 * @since 1.0
 */
@SpringBootApplication
@RestController
public class ApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTest.class, args);
    }

    @GetMapping(value = "/demo/testBusinessException")
    public void testBusinessException() {
        throw new BusinessException(-2, "业务错误");
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
