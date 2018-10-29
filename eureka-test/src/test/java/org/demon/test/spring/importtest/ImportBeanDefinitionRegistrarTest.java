package org.demon.test.spring.importtest;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/29 11:25
 * @since 1.0
 */
public class ImportBeanDefinitionRegistrarTest implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // new一个RootBeanDefinition
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(ImportB.class);
        // 注册一个名字叫rectangle的bean
        registry.registerBeanDefinition("importB", rootBeanDefinition);
    }
}
