package kurs;

import java.util.Arrays;
import java.util.Random;

public class MyUtils {
    public final Random random = new Random();

    public String charStr(char c, int length) {
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        return new String(chars);
    }

    public String leftPad(String s, int length, char c) {
        int len = s.length();
        if (len == length) return s;
        if (len > length) return s.substring(0, length);
        return charStr(c, length - len) + s;
    }

    public String leftPad(String s, int length) {
        return leftPad(s, length, ' ');
    }
}
