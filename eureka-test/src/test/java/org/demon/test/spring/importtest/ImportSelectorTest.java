package org.demon.test.spring.importtest;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author demon
 * @version 1.0
 * @date 2018/10/29 11:22
 * @since 1.0
 */
public class ImportSelectorTest implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"org.demon.test.spring.importtest.ImportC"};
    }
}
