import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CipherSym {
    public static void main(String[] args) throws Exception {
        KeyGenerator gen = KeyGenerator.getInstance("DES");
        SecretKey key = gen.generateKey();

        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] iv = cipher.getIV();

        byte[] c0 = cipher.update(new byte[]{1,2,3,4});
        byte[] c1 = cipher.update(new byte[]{6,5,7,8,9,9,4,4});
        byte[] c2 = cipher.update(new byte[]{10,10,5});
        byte[] c3 = cipher.doFinal(new byte[]{9,0,1});

        System.out.println(cipher.getBlockSize());
    }
}