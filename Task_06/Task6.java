
import java.security.MessageDigest;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class DESTwoThree{
    Cipher eCipher;
    Cipher dCipher;

    DESTwoThree(SecretKey sk, IvParameterSpec iv) throws Exception {
        eCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        dCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        
        eCipher.init(Cipher.ENCRYPT_MODE, sk, iv);
        dCipher.init(Cipher.DECRYPT_MODE, sk, iv);
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

public class Task6{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to ecrypt: ");
        final String secretText = sc.next();    
        System.out.println("SecretText: " + secretText);

        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes("utf-8"));
        // key length adjustment
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

        // This step is necessary to meet the 24-byte key length requirement for 3DES.
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);

        DESTwoThree dtt = new DESTwoThree(key, iv);
        String enc = dtt.encrypt(secretText);
        System.out.println(enc);

        String dec = dtt.decrypt(enc);
        System.out.println(dec);

        sc.close();
    }
}