package org.demon.design.proxy;

import java.lang.reflect.Proxy;

public class Test {

    public static IDBQuery createJdkProxy() {
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}, new JDKDbQueryHandler());
        return jdkProxy;
    }

    public static void main(String[] args) {
        System.out.println(createJdkProxy());
    }
}
