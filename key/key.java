import java.util.Random;
import java.math.*;
public class key
{
  //KEYS HAVE TO BE PRIME
  public static boolean isPrime(int n)
  {for (int x = 2; x < n; x++){  if (n % x == 0)  return false;} return true;}
  //GENEREATE PUBLIC KEY
  public static int generateKey (int range)
  {
    Random rand = new Random();  int key = (rand.nextInt(range) + 1);
    while (!isPrime(key) || key == 1){  key = (rand.nextInt(range) + 1);}
    return (key);
  }
  //GREATEST COMMON FACTOR
  public static  BigInteger GCD(BigInteger a, BigInteger b)
  {
    if (b.compareTo(BigInteger.ZERO) == 0)
    return a;
    return GCD(b,a.mod(b));
  }

  public static void main (String[] args)
  {
    BigInteger p,q,n,p1,q1,phi,k,d,e,encrypt,decrypt; int range,value1,value2;
    range = 10;
    value1 = generateKey(range); value2 = generateKey(range);

    while (value1 == value2)  { value1 = generateKey(range); value2 = generateKey(range);}
    p = BigInteger.valueOf(value1); q = BigInteger.valueOf(value2);
    p1 = p.subtract(BigInteger.valueOf(1)); q1 = q.subtract(BigInteger.valueOf(1));
    n = p.multiply(q); phi = p1.multiply(q1);
    System.out.println("P\t=\t" + p);     System.out.println("Q\t=\t" + q);
    System.out.println("P1\t=\t" + p1);   System.out.println("Q1\t=\t" + q1);
    System.out.println("PHI\t=\t" + phi); System.out.println("N\t=\t" + n);
    e = BigInteger.valueOf(2);
    while (e.compareTo(BigInteger.ONE) == 1 &&e.compareTo(phi) == -1)
    {  if (GCD(e,phi).equals(BigInteger.ONE) == true)  {      break;  }   else      e = e.add(BigInteger.ONE);    System.out.println("e: incremented : " + e);}
    System.out.println("e\t=\t" + e);

    int messageNumber = 20;
    int key = 2;
    k = new BigInteger(Integer.toString(key));
    BigInteger message = new BigInteger(Integer.toString(messageNumber));
    System.out.println("message = " + message);
    encrypt = (message.pow(e.intValue())).mod(n);
    System.out.println("encrypt : " +  encrypt);
    d = (k.multiply(phi).add(BigInteger.ONE)).divide(e);
    System.out.println("d : " + d);
    decrypt = (encrypt.pow(d.intValue())).mod(n);
    System.out.println("decrypt : " + decrypt);




  }
}
