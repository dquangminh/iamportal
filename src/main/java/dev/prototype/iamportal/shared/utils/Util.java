package dev.prototype.iamportal.shared.utils;

import java.security.SecureRandom;

public class Util {
    private Util() {}

    private static final SecureRandom BIGINT_RAND = new SecureRandom();
    private static final SecureRandom INT_RAND = new SecureRandom();
    private static final StringRandom STR8_RAND = new StringRandom(8);

    public static final String DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static Long generateBigInt() {
        return BIGINT_RAND.nextLong();
    }

    public static Integer generateInt() {
        return INT_RAND.nextInt(0, Integer.MAX_VALUE);
    }

    public static String generateString8() {
        return STR8_RAND.nextString();
    }
}
