package org.demon.advice;

import org.demon.bean.BaseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/18 17:53
 * @since 1.0
 */
@RestControllerAdvice
public class ResponseBodyAdviceHandler implements ResponseBodyAdvice {
    /**
     * 判断哪些需要拦截
     *
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return {@code true} if {@link #beforeBodyWrite} should be invoked;
     */
    @Override
    public boolean supports(@NonNull MethodParameter returnType, @NonNull Class converterType) {
        return true;
    }


    @Override
    public Object beforeBodyWrite(Object body, @NonNull MethodParameter returnType,
                                  @NonNull MediaType selectedContentType,
                                  @NonNull Class selectedConverterType, @NonNull ServerHttpRequest request,
                                  @NonNull ServerHttpResponse response) {
        BaseResult<Object> result = new BaseResult<>();
        result.setStatus(1000);
        result.setMsg("成功");
        result.setData(body);
        return result;
    }
}
