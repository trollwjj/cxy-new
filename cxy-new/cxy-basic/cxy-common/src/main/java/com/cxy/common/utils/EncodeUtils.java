package com.cxy.common.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeUtils {

    private static Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encode(String origin){
        String encodePassword = bCryptPasswordEncoder.encode(origin);
        return encodePassword;
    }

    public static String encode(String origin, String salt){
        String encodePassword = md5PasswordEncoder.encodePassword(origin, salt);
        return  encodePassword;
    }


    public static boolean isRight(String origin, String encodePassword){
        boolean matches = bCryptPasswordEncoder.matches(origin, encodePassword);
        return matches;
    }

    public static boolean isRight(String origin, String encodePassword, String salt){
        boolean passwordValid = md5PasswordEncoder.isPasswordValid(origin, encodePassword, salt);
        return passwordValid;
    }



}
