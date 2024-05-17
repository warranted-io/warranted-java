package io.warranted;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * <p>CryptoHelper class.</p>
 *
 * @author warranted.io
 * @version $Id: $Id
 */
public class CryptoHelper {

    /**
     * Function does a time-safe comparison
     *
     * @param a the first string
     * @param b the second string
     * @return true if they're equal, else false.
     */
    public static boolean timeSafeCompare(String a, String b) {
        try {
            return MessageDigest.isEqual(a.getBytes(StandardCharsets.UTF_8), b.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Function to create HMAC of a JSON request
     *
     * @param url the destination URL
     * @param jsonData JSON request data
     * @param secretKey Secret key for HMAC
     * @return HMAC value
     */
    public static String createHMAC(String url, String jsonData, String secretKey) {
        return createHMAC(url, jsonData, secretKey, "HmacSHA256");
    }

    /**
     * Function to create HMAC of a JSON request
     *
     * @param url the destination URL
     * @param jsonData JSON request data
     * @param secretKey Secret key for HMAC
     * @param algorithm Hashing algorithm (e.g., "HmacSHA256", "HmacSHA512")
     * @return HMAC value
     */
    public static String createHMAC(String url, String jsonData, String secretKey, String algorithm) {
        try {
            Mac mac = Mac.getInstance(algorithm);
            Key key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), algorithm);
            mac.init(key);
            byte[] data = (url + jsonData).getBytes(StandardCharsets.UTF_8);
            byte[] hmacBytes = mac.doFinal(data);
            return bytesToHex(hmacBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hexString.append("0");
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
