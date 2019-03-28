package org.demon.classloader;

public class Book {

    public static void main(String[] args) {
        staticFunction();
    }

    static Book book = new Book();

    static {
        System.out.println("static");
    }


    Book() {
        System.out.println("书的构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    public static void staticFunction() {
        System.out.println("书的静态方法");
    }

    int price = 110;
    static int amount = 112;
    static final int famount = 113;

    {
        System.out.println("normal1");
    }

    {
        System.out.println("normal");
    }

}
