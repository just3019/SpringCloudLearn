package org.demon.design.singleton;

public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("创建内部类单例");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
