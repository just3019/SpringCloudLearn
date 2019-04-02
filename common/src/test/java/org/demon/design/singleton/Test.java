package org.demon.design.singleton;

public class Test {

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            //Singleton.getInstance();
            //LazySingleton.getInstance();
            StaticSingleton.getInstance();
        }
        System.out.println(System.currentTimeMillis() - t);
    }
}
