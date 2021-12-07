package com.example.demo2.global.crypt;

import org.bouncycastle.crypto.CryptoException;

import java.io.UnsupportedEncodingException;

public interface Crypt {

    public static final int DEFAULT_KEY = 0; //- Default keySet
    public static final int FILE_KEY    = 1; //- File keySet
    public static final int DB_KEY      = 2; //- DataBase keySet

    public static final String FILE_PATH = "/";
    public static final String FILE_NAME = "SecertKey.ser";

    public String decryptText(String encryptMsg) throws CryptoException,Exception;

    public String encryptText(String plainMsg) throws CryptoException,Exception;

    public String cryptoSHA3(String key) throws UnsupportedEncodingException,Exception;
}
