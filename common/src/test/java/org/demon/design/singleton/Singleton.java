package org.demon.design.singleton;

public class Singleton {

    private Singleton() {
        System.out.println("创建单例");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
