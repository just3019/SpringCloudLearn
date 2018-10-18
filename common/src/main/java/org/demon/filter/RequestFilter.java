package org.demon.filter;

import lombok.extern.apachecommons.CommonsLog;
import org.demon.util.Charsets;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/17 15:01
 * @since 1.0
 */
@CommonsLog
public class RequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        long time = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        time = System.currentTimeMillis() - time;
        log.info(MessageFormat.format("耗时：{{0}}", time));

    }


    /**
     * 设置请求字符集
     */
    public void setRequestCharset(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
        httpServletRequest.setCharacterEncoding(Charsets.UTF_8);
    }


    /**
     * 设置响应字符集
     */
    public void setResponseCharset(HttpServletResponse response) {
        response.setCharacterEncoding(Charsets.UTF_8);
    }

}
