// src : https://www.knowledgefactory.net/2019/10/java-des-encryption-and-decryption-with-example.html

import javax.crypto.*;
import java.util.*;

class MyDES {

    Cipher eCipher;
    Cipher dCipher;

    MyDES(SecretKey key) throws Exception {
        eCipher = Cipher.getInstance("DES");
        dCipher = Cipher.getInstance("DES");
        eCipher.init(Cipher.ENCRYPT_MODE, key);
        dCipher.init(Cipher.DECRYPT_MODE, key);
    }

    public String encrypt(String str) throws Exception {
        byte[] byteData = str.getBytes("UTF8");
        // doFinal expects type of byte[] and returns byte[]
        byte[] enc = eCipher.doFinal(byteData);

        // Encode bytes to base64 to get a string
        return Base64.getEncoder().encodeToString(enc);
    }

    public String decrypt(String str) throws Exception {
        byte[] dec = Base64.getDecoder().decode(str);
        // doFinal expects type of byte[] and returns byte[]
        byte[] byteData = dCipher.doFinal(dec);

        return new String(byteData, "UTF8");
    }
}

class Task2 {
    public static void main(String[] argv) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to ecrypt: ");
        final String secretText = sc.next();
        System.out.println("SecretText: " + secretText);

        // generation of Secret key
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();

        // Instantiation of our custom class
        MyDES myDES = new MyDES(key);

        String encrypted = myDES.encrypt(secretText);
        System.out.println("Encrypted Value: " + encrypted);

        String decrypted = myDES.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

        sc.close();
    }
}