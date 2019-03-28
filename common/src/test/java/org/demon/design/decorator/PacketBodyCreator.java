package org.demon.design.decorator;

public class PacketBodyCreator implements IPacketCreator {


    @Override
    public String handleContent() {
        return "hello word";
    }
}
