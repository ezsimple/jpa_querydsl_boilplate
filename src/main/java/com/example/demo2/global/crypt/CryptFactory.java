package com.example.demo2.global.crypt;

public class CryptFactory {

    public CryptFactory() {
        super();
    }

    public static Crypt getInstance(int clas) {
        Crypt crypt = null;

        try {
            switch (clas) {
                case Crypt.DEFAULT_KEY:
                    crypt = new CryptImpl();
                    break;

                case Crypt.FILE_KEY:
                    //	crypt = new FileCryptImpl(); 구현하지 않음.
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return crypt;
    }

}
