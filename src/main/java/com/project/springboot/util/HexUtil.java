package com.project.springboot.util;

import com.project.springboot.exception.InvalidHexException;

import java.nio.charset.StandardCharsets;

public class HexUtil {

    private HexUtil() {
    }

    public static String decode(String hexValue) {

        if (hexValue == null || hexValue.isBlank()) {
            return hexValue;
        }

        if ((hexValue.length() % 2) != 0) {
            throw new InvalidHexException(
                    "Hex value must contain an even number of characters");
        }

        byte[] bytes = new byte[hexValue.length() / 2];

        for (int i = 0; i < hexValue.length(); i += 2) {

            int high = Character.digit(hexValue.charAt(i), 16);
            int low = Character.digit(hexValue.charAt(i + 1), 16);

            if (high == -1 || low == -1) {
                throw new InvalidHexException(
                        "Invalid Hex value: " + hexValue);
            }

            bytes[i / 2] = (byte) ((high << 4) + low);
        }

        return new String(bytes, StandardCharsets.UTF_8);
    }
}
