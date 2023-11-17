import java.math.BigInteger;
import java.security.*;
import java.util.Scanner;

public class Task10 {
	public static void main(String[] args) {
		System.out.println("Enter String to Hash:");
		Scanner sc = new Scanner(System.in);
		String inp = sc.next();
		System.out.println(md5(inp));
	}

	public static String md5(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes());

			// 1-> positive number 16-> for hexa to string
			String md5 = new BigInteger(1, digest.digest()).toString(16);
			return md5;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}