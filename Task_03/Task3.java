import javax.crypto.*;
import java.util.*;

class MyBlowFish{
    Cipher eCipher;
    Cipher dCipher;

    MyBlowFish(SecretKey sk) throws Exception {
        eCipher = Cipher.getInstance("Blowfish");
        dCipher = Cipher.getInstance("Blowfish");

        eCipher.init(Cipher.ENCRYPT_MODE, sk);
        dCipher.init(Cipher.DECRYPT_MODE, sk);
    }

    public String encrypt(String str) throws Exception {
        byte[] byteData = str.getBytes("UTF8");
        //doFinal expects type of byte[] and returns byte[]
        byte[] enc = eCipher.doFinal(byteData);

        // Encode bytes to base64 to get a string
        return Base64.getEncoder().encodeToString(enc);
    }

    public String decrypt(String str) throws Exception {
        byte[] dec = Base64.getDecoder().decode(str);
        //doFinal expects type of byte[] and returns byte[]
        byte[] byteData = dCipher.doFinal(dec);

        return new String(byteData, "UTF8");
    }
}

public class Task3{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to ecrypt: ");
        final String secretText = sc.next();
        System.out.println("SecretText: " + secretText);

        // generation of Secret key
        SecretKey key = KeyGenerator.getInstance("Blowfish").generateKey();
        
        // Instantiation of our custom class
        MyBlowFish myBlFish = new MyBlowFish(key);

        String encrypted = myBlFish.encrypt(secretText);
        System.out.println("Encrypted Value: " + encrypted);

        String decrypted = myBlFish.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

        sc.close();
    }
}