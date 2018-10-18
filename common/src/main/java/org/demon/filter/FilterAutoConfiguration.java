package org.demon.filter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/18 14:58
 * @since 1.0
 */
@Configuration
public class FilterAutoConfiguration {

    @Configuration
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    static class ServletFilterConfiguration extends FilterAutoConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public RequestFilter requestFilter() {
            return new RequestFilter();
        }

    }
}
