package org.demon.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    @Test
    public void test() {
        List<String> handler = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            //HugeString h = new HugeString();
            ImprovedHugeString h = new ImprovedHugeString();
            handler.add(h.getSubString(1, 5));
        }
    }

    @Test
    public void addTest() {
        String a = "aaa" + "bbb";
    }
}
