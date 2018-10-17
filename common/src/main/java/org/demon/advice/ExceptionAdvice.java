package org.demon.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/17 17:22
 * @since 1.0
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = Throwable.class)
    public Object errorHandler(Throwable e) {

        if (e instanceof OutOfMemoryError) {
            System.exit(0);
            return null;
        }

        return null;
    }

}
