package org.demon.design.decorator;

public class PacketCreator implements IPacketCreator {


    @Override
    public String handleContent() {
        return "hello word";
    }
}
