package org.demon.design.singleton;

public class LazySingleton {

    private LazySingleton() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("创建延时单例");
    }

    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
