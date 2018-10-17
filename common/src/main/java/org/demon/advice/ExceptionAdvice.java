package org.demon.advice;

import lombok.extern.apachecommons.CommonsLog;
import org.demon.bean.BaseResult;
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

        if (e instanceof OutOfMemoryError) {
            System.exit(0);
            return null;
        }
        BaseResult<Void> result = new BaseResult<>();
//        body.setStatus(statusInfo.getCode());
//        body.setMsg(statusInfo.getMessage());
        return result;
    }

}
