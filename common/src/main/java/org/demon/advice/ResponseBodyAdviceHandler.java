package org.demon.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/18 17:53
 * @since 1.0
 */
@ControllerAdvice
public class ResponseBodyAdviceHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(@NonNull MethodParameter returnType, @NonNull Class converterType) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, @NonNull MethodParameter returnType,
                                  @NonNull MediaType selectedContentType,
                                  @NonNull Class selectedConverterType, @NonNull ServerHttpRequest request,
                                  @NonNull ServerHttpResponse response) {
        return null;
    }
}
