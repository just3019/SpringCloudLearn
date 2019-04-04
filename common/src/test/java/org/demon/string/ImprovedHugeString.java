package org.demon.string;

public class ImprovedHugeString {

    private String str = new String(new char[100000]);

    public String getSubString(int begin, int end) {
        return new String(str.substring(begin, end));
    }
}
