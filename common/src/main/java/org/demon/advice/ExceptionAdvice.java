package org.demon.advice;

import lombok.extern.apachecommons.CommonsLog;
import org.demon.bean.BaseResult;
import org.demon.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author demon
 * @version 1.0
 * @date 2018/10/17 17:22
 * @since 1.0
 */
@RestControllerAdvice
@CommonsLog
public class ExceptionAdvice {


    @ExceptionHandler(value = Throwable.class)
    public Object errorHandler(Throwable e) {
        log.error(e.getMessage(), e);

        if (e.getCause() instanceof OutOfMemoryError) {
            System.exit(0);
            return null;
        } else if (e instanceof BusinessException) {
            log.warn(e.getMessage(), e);
            BusinessException businessException = (BusinessException) e;
            return new BaseResult<Void>(businessException.getCode(), businessException.getMessage());
        } else {
            log.error(e.getMessage(), e);
            return new BaseResult<Void>(-1, "未知错误");
        }
    }

}
