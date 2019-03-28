package org.demon.design;

class Singleton {
    private Singleton() {
        System.out.println("Singleton is create");
    }

    private static Singleton instance = new Singleton();

    static Singleton getInstance() {
        return instance;
    }

}

class LazySingleton {
    private LazySingleton() {
        System.out.println("LazySingleton is create");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

class Test {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            Singleton.getInstance();
            //LazySingleton.getInstance();
        }
        System.out.println(System.currentTimeMillis() - t);

    }
}


