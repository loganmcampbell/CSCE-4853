import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class hmac
{
  public static String bytesToHex(byte[] bytes)
  {
      final  char[] hexArray = "0123456789ABCDEF".toCharArray();
      char[] hexChars = new char[bytes.length * 2];
      for ( int j = 0; j < bytes.length; j++ )
      {
          int v = bytes[j] & 0xFF;
          hexChars[j * 2] = hexArray[v >>> 4];
          hexChars[j * 2 + 1] = hexArray[v & 0x0F];
      }
      return new String(hexChars);
  }

public static void main(String[] args)
{
    Mac sha256_HMAC = null;
    String result = null;
    String key =  "SECRET KEY GOES HERE";
    String MESSAGE = "hello?";
    try{
        byte [] byteKey = key.getBytes("UTF-8");
        final String HMAC_SHA256 = "HmacSHA256";
        sha256_HMAC = Mac.getInstance(HMAC_SHA256);
        SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA256);
        sha256_HMAC.init(keySpec);
        byte [] mac_data = sha256_HMAC.

        doFinal(MESSAGE.getBytes("UTF-8"));
        result = bytesToHex(mac_data);
        System.out.println(result);
    }
    catch (UnsupportedEncodingException e)  {        e.printStackTrace();}
    catch (NoSuchAlgorithmException e)      {        e.printStackTrace();}
    catch (InvalidKeyException e)           {        e.printStackTrace();}
    finally                                 {  System.out.println("HMAC-SHA256: DONE");}


}


}
