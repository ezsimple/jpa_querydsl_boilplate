package com.example.demo2.global.crypt;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.lang3.StringUtils;

public class CryptoUtil {

    /**
     * 양방향 Encrypt - 계좌번호등 암복호화가 필요한 경우 사용
     * @param strPlain
     * @return
     * @throws Exception
     */
    public static String encrypt(String strPlain) {
        String strHexed = "";
        try {
            strHexed = crypt.encryptText(strPlain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strHexed;
    }

    /**
     * 양방향 Decrypt - 계좌번호등 암복호화가 필요한 경우 사용
     * @param strHexed
     * @return
     * @throws Exception
     */
    public static String decrypt(String strHexed) {

        String strPlain = "";

        try {
            strPlain = crypt.decryptText(strHexed);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return strPlain;
    }

    public static String decryptThrowEx(String strHexed) {

        String strPlain = "";

        try {
            strPlain = crypt.decryptText(strHexed);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return strPlain;
    }

    /**
     * 단방향 SHA3 - 비밀번호 암호화 사용
     * @param strPlain
     * @return
     * @throws Exception
     */
    public static String encryptSHA3(String strPlain) {

        String sha3Str = "";

        try {
            sha3Str = crypt.cryptoSHA3(strPlain);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return sha3Str;
    }

    private static Crypt crypt= null;
    static
    {
        try {
            crypt = CryptFactory.getInstance(Crypt.DEFAULT_KEY);
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 난수 번호 생성
     * @param n
     * @return
     */
    public static int randomNumber(int n) {

        SecureRandom secureRandom = null;
        try {

            secureRandom = SecureRandom.getInstance("SHA1PRNG");

        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String returnValue = StringUtils.substring(Integer.toString(secureRandom.nextInt(999999)), 0, n);
        return Integer.parseInt(StringUtils.rightPad(returnValue, n, '0'));
    }
}
