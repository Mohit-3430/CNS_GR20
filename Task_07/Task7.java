import java.math.BigInteger;
import java.util.*;

class RSA {
    private BigInteger p, q, N, phi, e, d;
    private int bitlength = 1024;
    private int blocksize = 256;

    private Random r;

    public RSA() {
        r = new Random();
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }

    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }
}

public class Task7 {
    public static void main(String[] args) {
        RSA rsa = new RSA();
        Scanner sc = new Scanner(System.in);
        String teststring;
        System.out.println("Enter the plain text:");
        teststring = sc.next();

        System.out.println("String: " + teststring);
        // System.out.println("String in Bytes: " +
        // bytesToString(teststring.getBytes()));

        byte[] encrypted = rsa.encrypt(teststring.getBytes());

        // any of the following print statements
        System.out.println("Encrypted String in Bytes: " + Base64.getEncoder().encodeToString(encrypted));
        System.out.println("Encrypted String in Bytes: " + new BigInteger(1, encrypted).toString(16));

        byte[] decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypted String: " + new String(decrypted));

        sc.close();
    }
}
