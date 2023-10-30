import java.security.*;

public class Playground
{
    public static void main(String[] args) throws Exception {

        // Generating key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Creating a Signature object
        Signature signature = Signature.getInstance("SHA256withRSA");

        // Initializing the signature
        signature.initSign(keyPair.getPrivate());

        // Data to be signed
        String data = "Hello, this is the text to be signed.";

        // Update the data to be signed
        signature.update(data.getBytes());

        // Generate the digital signature
        byte[] digitalSignature = signature.sign();

        // TODO : Fix this line
        System.out.println("Digital Signature: " + new String(digitalSignature));

        // Verification
        Signature verificationSignature = Signature.getInstance("SHA256withRSA");
        verificationSignature.initVerify(keyPair.getPublic());
        verificationSignature.update(data.getBytes());

        // Verify the digital signature
        boolean isVerified = verificationSignature.verify(digitalSignature);
        System.out.println("Signature verified: " + isVerified);

    }
}

/*
OP:
Digital Signature : some rubbish
Signature verified : true
*/