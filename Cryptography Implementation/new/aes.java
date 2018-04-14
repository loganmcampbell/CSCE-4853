import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class aes
{
    private static SecretKeySpec secretKey; private static byte[] key;
    // SET UP KEY // GET KEY
    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    //ENCRYPT STRING//TEXT//MESSAGE
    public static String encrypt(String stringE, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(stringE.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    //DECRYPT BY DECODE FUNCTION : MESSAGE
    public static String decrypt(String stringD, String secret)
    {
        try
        {   setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(stringD)));
        }
        catch (Exception e){  System.out.println("Error while decrypting: " + e.toString());}
        return null;
    }

    public static void main(String[] args)
    {
      final String secretKey = "LOGAN CAMPBELL";

      String originaltxt = "Happy Friday The 13th!!!!!";
      String encryptedtxt = encrypt(originaltxt, secretKey) ;
      String decryptedtxt = decrypt(encryptedtxt, secretKey) ;

      System.out.println(originaltxt);
      System.out.println(encryptedtxt);
      System.out.println(decryptedtxt);
    }
}
