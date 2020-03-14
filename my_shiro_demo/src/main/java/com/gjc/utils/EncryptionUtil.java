package com.gjc.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.HashMap;
import java.util.Map;

public class EncryptionUtil {

    public static Map<String, String> encryption(String password) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        String newPassword = new Md5Hash(password, salt, 2).toString();
        Map<String, String> map = new HashMap<>();
        map.put("salt", salt);
        map.put("password", newPassword);
        return map;
    }
}
