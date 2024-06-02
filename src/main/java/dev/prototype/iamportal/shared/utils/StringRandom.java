package dev.prototype.iamportal.shared.utils;

import java.security.SecureRandom;

public class StringRandom {
    public static final String upper = "QWERTYUIOPASDFGHJKLZXCVBNM";
    public static final String lower = "qwertyuiopasdfghjklzxcvbnm";
    public static final String digit = "0123456789";
    public static final String alphanum = upper + lower + digit;

    public final SecureRandom random = new SecureRandom();

    private final char[] symbols;
    private final char[] buf;

    public StringRandom(int length, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();

        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    public StringRandom(int length) {
        this(length, alphanum);
    }

    public String nextString() {
        for (int idx = 0; idx < buf.length; idx++) {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }

        return new String(buf);
    }
}
