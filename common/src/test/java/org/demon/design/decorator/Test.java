package org.demon.design.decorator;

public class Test {

    public static void main(String[] args) {
        IPacketCreator pc = new PacketHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketCreator()));
        System.out.println(pc.handleContent());
    }
}
