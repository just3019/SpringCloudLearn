package org.demon.util;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * desc: 方法工具
 *
 * @author demon
 * @date 2018-11-21 17:14
 */
public class FunctionUtil {

    /**
     * 当 val 值存在的时候，执行传入的方法，否则不处理
     * If a value is present, performs the given action with the value,
     * otherwise does nothing
     *
     * @param c   处理方法
     * @param val 值
     */
    public static <T> void whenNonNullDo(Consumer<T> c, T val) {
        Optional.ofNullable(val).ifPresent(c);
    }

}
