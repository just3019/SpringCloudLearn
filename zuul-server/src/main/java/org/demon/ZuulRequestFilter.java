package org.demon;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.RIBBON_ROUTING_FILTER_ORDER;

/**
 * @author demon
 * @version 1.0
 * @date 2018/7/31 11:41
 * @since 1.0
 */
public class ZuulRequestFilter extends ZuulFilter {

    private static final Logger logger = Logger.getLogger("ZuulRequestFilter");

    @Override
    public String filterType() {
        System.out.println("filterType");
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        System.out.println("filterOrder");
        return RIBBON_ROUTING_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("shouldFilter");
        return true;
    }

    @Override
    public Object run() {
        System.out.println("runrunrunrunrunrunrunrunrunrunrunrunrunrunrunrunrunrunrunrunrunrun");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        ctx.set("loadBalancerKey", "hahaha");
        logger.info(request.getMethod() + " " + request.getRequestURL().toString());
        return null;
    }
}
