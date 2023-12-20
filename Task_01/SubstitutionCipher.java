import java.util.*;

public class SubstitutionCipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String to encrypt");
		String inp = sc.next();

		String encrypt = transform(inp);
		String decrypt = transform(encrypt);
		System.out.println("The encrypted data is: " + encrypt);
		System.out.println("The decrypted data is: " + decrypt);

		sc.close();
	}

	// Main logic is to do REVERSE MAPPING [monoalphabetic cipher]
	// a->z, b->y, c->x .... y->b, z->a
	public static String transform(String encrypt) {
		String decrypt = "";
		for (int i = 0; i < encrypt.length(); i++) {
			int ch = encrypt.charAt(i) - 'a';
			int revIndex = (26 - ch) - 1; // for 0 index
			char revChar = (char) ('a' + revIndex);
			decrypt = decrypt + revChar;
		}
		return decrypt;
	}
}
