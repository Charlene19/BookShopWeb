package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author zvr
 */
public class HashUtil {

    public HashUtil() {

    }

    /**
     * Computes and outputs a hashed value
     * 
     * @param text The text to hash
     * @return hashed value
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException 
     */
    public String hashText(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        if (text == null) {
            return null;
        }

        String hashedText = "";

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytesHash = messageDigest.digest(text.getBytes("UTF-8"));

        for (byte b : bytesHash) {
            hashedText += String.valueOf(String.format("%02x", b));
        }
        return hashedText;
    }

}
