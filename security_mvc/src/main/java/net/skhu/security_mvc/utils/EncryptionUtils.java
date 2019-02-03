package net.skhu.security_mvc.utils;

import java.security.MessageDigest;

public class EncryptionUtils {

    public static String encryptSHA256(String s) {
        return encrypt(s, "SHA-256");
    }

    public static String encryptMD5(String s) {
        return encrypt(s, "MD5");
    }

    //messageDigest 파라미터. 이 파라미터는 암호화 알고리즘을 지정한다.
    //SHA-256 알고리즘이나 MD5 알고리즘을 지정할 수 있다.
    //SHA-256 알고리즘이 MD5 알고리즘보다 좀 더 강력하다.
    public static String encrypt(String s, String messageDigest) {
        try {
            MessageDigest md = MessageDigest.getInstance(messageDigest);
            byte[] passBytes = s.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) sb.append(Integer.toHexString(0xff & digested[i]));
            return sb.toString();
        } catch (Exception e) {
            return s;
        }
    }

}
