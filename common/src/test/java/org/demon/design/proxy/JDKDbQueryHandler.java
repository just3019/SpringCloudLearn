package org.demon.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKDbQueryHandler implements InvocationHandler {

    IDBQuery real = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

}
