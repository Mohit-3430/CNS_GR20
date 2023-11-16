
import java.security.*;
import java.util.*;

public class Task9 {
    public static void main(String[] a) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            System.out.println("Message digest object info:");

            System.out.println("Algorithm=" + md.getAlgorithm());
            System.out.println("Provider=" + md.getProvider());
            System.out.println("ToString=" + md.toString());

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the pt:");
            String input = sc.next();

            md.update(input.getBytes());
            byte[] output = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : output) {
                sb.append(String.format("%02x", b));
            }

            System.out.println("Hashed Output: " + sb.toString());
            // input = "abc";
            // input = "abcdefghijklmnopqrstuvwxyz";

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
    }
}
