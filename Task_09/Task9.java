
import java.math.BigInteger;
import java.security.*;
import java.util.*;

public class Task9 {
    public static void main(String[] a) {
        System.out.println("Enter String to Hash:");
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        System.out.println(sha1(inp));
    }

    public static String sha1(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA1");
            digest.update(input.getBytes());

            // 1-> positive number 16-> for hexa to string
            String sha1 = new BigInteger(1, digest.digest()).toString(16);
            return sha1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}

// =============== old code ===========================
// try {
// MessageDigest md = MessageDigest.getInstance("SHA1");
// System.out.println("Message digest object info:");
//
// System.out.println("Algorithm=" + md.getAlgorithm());
// System.out.println("Provider=" + md.getProvider());
// System.out.println("ToString=" + md.toString());

// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the pt:");
// String input = sc.next();
// System.out.println(sha1(input));

// md.update(input.getBytes());
// byte[] output = md.digest();
// StringBuilder sb = new StringBuilder();
// for (byte b : output) {
// sb.append(String.format("%02x", b));
// }

// System.out.println("Hashed Output: " + sb.toString());
// //input = "abc";
// //input = "abcdefghijklmnopqrstuvwxyz";

// } catch (Exception e) {
// System.out.println("Exception:" + e);
// }