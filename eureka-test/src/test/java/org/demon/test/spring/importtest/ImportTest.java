package org.demon.test.spring.importtest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

/**
 * @Import 注解使用测试。
 * 1.能直接将需要的bean在spring工厂中实例化。顺序{Configuration}>{ImportSelector}>{ImportBeanDefinitionRegistrar}
 *
 * @author demon
 * @version 1.0
 * @date 2018/10/29 10:54
 * @since 1.0
 */
@Import({ImportA.class, ImportBeanDefinitionRegistrarTest.class, ImportSelectorTest.class})
public class ImportTest {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        System.out.println("开始");
        applicationContext = new AnnotationConfigApplicationContext(ImportTest.class);
    }


    @Test
    public void test_1() {
        String[] classNamelist = applicationContext.getBeanDefinitionNames();
        Arrays.stream(classNamelist).forEach(a -> System.out.println("======> " + a));
        ImportA importA = applicationContext.getBean(ImportA.class);
        importA.test();

    }

}
