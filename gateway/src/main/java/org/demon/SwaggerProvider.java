package org.demon;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.common.HostNameProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author demon
 * @version 1.0
 * @date 2018/9/10 10:04
 * @since 1.0
 */
@Component
@Primary
@AllArgsConstructor
public class SwaggerProvider implements SwaggerResourcesProvider {
    private static final String API_URI = "/v2/api-docs";
    private final DiscoveryClient discoveryClient;


    /**
     * 初始化swagger
     *
     * @return @see springfox.documentation.swagger.web.SwaggerResource
     */
    @Override
    public List<SwaggerResource> get() {
        return discoveryClient.getServices().stream().map(this::swaggerResource).collect(Collectors.toList());
    }

    /**
     * 生成swaggerResource对象
     *
     * @param name 服务名称
     * @return @see springfox.documentation.swagger.web.SwaggerResource
     */
    private SwaggerResource swaggerResource(String name) {
        SwaggerResource swaggerResource = new SwaggerResource();
        System.out.println(name);
        swaggerResource.setName(name);
        swaggerResource.setUrl("/" + name + API_URI);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
