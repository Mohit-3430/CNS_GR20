import java.math.BigInteger;
import java.security.*;

public class Task10 {
	public static void main(String[] args) {
		System.out.println("For null " + md5(""));
		System.out.println("For simple text " + md5("This is my text"));
		System.out.println("For simple numbers " + md5("12345"));
	}

	public static String md5(String input) {
		if (input == null)
			return null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes());

			// 1-> positive number 16-> for hexa to string
			String md5 = new BigInteger(1, digest.digest()).toString(16);
			return md5;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}