import java.security.*;
import java.security.*;
import javax.crypto.*;

public class KeyPairCipher {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        KeyPair keypair = gen.generateKeyPair();
        PublicKey k_e = keypair.getPublic();
        PrivateKey k_d = keypair.getPrivate();

        System.out.println(k_e.toString());
        System.out.println(k_d.toString());

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, k_e);
        byte[] result = cipher.doFinal(new byte[]{1,2,3,4,5,6});

        for (int i=0; i<result.length; ++i) {
            System.out.print(String.format("%x", result[i]) + " ");
        }
        System.out.println();
    }
}