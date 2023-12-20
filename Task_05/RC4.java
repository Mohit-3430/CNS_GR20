import java.util.*;

class RC4 {
    public static void main(String args[]) {
        int temp = 0;
        int s[] = new int[256]; // state vector
        int k[] = new int[256]; // key array

        Scanner sc = new Scanner(System.in);
        System.out.println("\n ENTER PLAIN TEXT\t");
        String ptext = sc.next();
        System.out.println("\n\nENTER KEY TEXT\t\t");
        String key = sc.next();

        int ptexti[] = new int[ptext.length()];
        int keyi[] = new int[key.length()];

        int cipher[] = new int[ptext.length()];
        int decrypt[] = new int[ptext.length()];

        for (int i = 0; i < ptext.length(); i++)
            ptexti[i] = (int) ptext.charAt(i);
        for (int i = 0; i < key.length(); i++)
            keyi[i] = (int) key.charAt(i);

        // the key values are repeated to make it 256 bits
        for (int i = 0; i < 255; i++) {
            s[i] = i;
            k[i] = keyi[i % key.length()];
        }

        // Key Scheduling
        int j = 0;
        for (int i = 0; i < 255; i++) {
            j = (j + s[i] + k[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        // Stream generation -> this will generate new key deonted by "z" here
        // this key will be used for encryption and decryption

        int i = 0;
        j = 0;
        int z = 0;
        for (int l = 0; l < ptext.length(); l++) {
            i = (l + 1) % 256;
            j = (j + s[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            z = s[(s[i] + s[j]) % 256];

            // Encrryption = newKey ^ PT
            // decryption = newKey ^ CT
            cipher[l] = z ^ ptexti[l];
            decrypt[l] = z ^ cipher[l];
        }
        System.out.println("\n\nENCRYPTED:\t\t");
        display(cipher);
        System.out.println("\n\nDECRYPTED:\t\t");
        display(decrypt);
    }

    static void display(int disp[]) {
        char convert[] = new char[disp.length];
        for (int l = 0; l < disp.length; l++) {
            convert[l] = (char) disp[l];
            System.out.print(convert[l]);
        }
    }

}