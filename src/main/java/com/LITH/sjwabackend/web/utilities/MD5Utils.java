package com.LITH.sjwabackend.web.utilities;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    public static String ConvertStringToMD5HexString(String input){
        byte[] bytes = digest(input);
        return bytesToHex(bytes);
    }

    private static byte[] digest(String input) {
        byte[] inputBytes = input.getBytes(UTF_8);
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(inputBytes);
        return result;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}