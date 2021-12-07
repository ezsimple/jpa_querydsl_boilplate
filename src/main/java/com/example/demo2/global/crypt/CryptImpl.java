package com.example.demo2.global.crypt;

import java.io.UnsupportedEncodingException;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.PaddedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jcajce.provider.digest.Keccak.DigestKeccak;

@SuppressWarnings("deprecation")
public class CryptImpl implements Crypt{

    private BufferedBlockCipher cipher;
    private KeyParameter key;
    public int keybit;

    public CryptImpl() {
        cipher = new PaddedBlockCipher((BlockCipher) new CBCBlockCipher(new AESEngine()));
        String newkey = KeyCode.DEFALUT_KEY;
        keybit = newkey.length();
        this.key = new KeyParameter(newkey.getBytes());
    }

    @Override
    public String decryptText(String encryptMsg) throws CryptoException, Exception {
        return decryptString(StringToByte(encryptMsg));
    }

    @Override
    public String encryptText(String plainMsg) throws CryptoException, Exception {
        return ByteToString(encryptString(plainMsg));
    }

    @Override
    public String cryptoSHA3(String key) throws UnsupportedEncodingException, Exception {
        /**
         * hash : 바이트수 / 256 , 118 , 384 , 512 등등의 암호화 방식 선택 (4가지 지원)
         * hash : 256 절대 변경 불가 */
        DigestKeccak md = new DigestKeccak(256);

        md.update(key.getBytes("UTF-8"));

        byte[] digest = md.digest();

        return org.bouncycastle.util.encoders.Hex.toHexString(digest);
    }

    //-- 입력된 Byte Array를 String로 반환한다.
    private String ByteToString(byte[] source) {
        String convert = new String();
        String temp = new String();
        for (int i = 0; i < source.length; i++) {
            temp = Integer.toHexString((int) (source[i]) << 0 & 0x000000FF);
            convert += (temp.length() == 1) ? "0" + temp : temp;
        }
        return convert;
    }

    //-- 입력된 String을 헥사코드로 반환한다.
    private int HexToInt(String value) {
        value = value.toUpperCase(); // 대문자로 변환
        int ret = 0;
        for (int i = 0; i < value.length(); i++) {
            int n = (int) value.charAt(i);
            n = n - 48;
            if (n > 9)
                n = n - 7;
            ret = (ret * 16) + n;
        }
        return ret;
    }

    //-- 입력된 String을 Byte Array로 반환한다.
    private byte[] StringToByte(String value) {
        byte[] temp = new byte[value.length() / 2];
        int v = 0;
        for (int i = 0; i < (value.length() / 2); i++) {
            temp[i] = (byte) (this.HexToInt(value.substring(v, v + 2)));
            v += 2;
        }
        return temp;
    }

    //-- Private routine that does the gritty work.
    private byte[] callCipher(byte[] data) throws CryptoException {
        int size = cipher.getOutputSize(data.length);
        byte[] result = new byte[size];

        int olen = cipher.processBytes(data, 0, data.length, result, 0);
        olen += cipher.doFinal(result, olen);

        if (olen < size) {
            byte[] tmp = new byte[olen];
            System.arraycopy(result, 0, tmp, 0, olen);
            result = tmp;
        }
        return result;
    }

    //-- Encrypt arbitrary byte array, returning the
    private synchronized byte[] encrypt(byte[] data) throws CryptoException {
        if (data == null || data.length == 0) {
            return new byte[0];
        }
        cipher.init(true, key);
        return callCipher(data);
    }


    //-- Encrypts a string.
    private byte[] encryptString(String data) throws CryptoException {
        if (data == null || data.length() == 0) {
            return new byte[0];
        }
        return encrypt(data.getBytes());
    }


    //-- Decrypts arbitrary data.
    private synchronized byte[] decrypt(byte[] data) throws CryptoException {
        if (data == null || data.length == 0) {
            return new byte[0];
        }
        cipher.init(false, key);
        return callCipher(data);
    }

    //-- Decrypts a string that was previously encoded
    //-- using encryptString.
    private String decryptString(byte[] data) throws CryptoException {
        if (data == null || data.length == 0) {
            return "";
        }
        return new String(decrypt(data));
    }
}
