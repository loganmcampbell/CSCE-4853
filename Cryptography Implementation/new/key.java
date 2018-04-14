import java.util.Random;
import java.math.*;
public class key
{
  //KEYS HAVE TO BE PRIME
  public static boolean isPrime(int n)
  {
    for (int x = 2; x < n; x++)
    {  if (n % x == 0)
        return false;
    }
    return true;
  }
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
    range = 100;
    value1 = generateKey(range); value2 = generateKey(range);
    while (value1 == value2)  { value1 = generateKey(range); value2 = generateKey(range);}
    p = BigInteger.valueOf(value1); q = BigInteger.valueOf(value2);
    p1 = p.subtract(BigInteger.valueOf(1)); q1 = q.subtract(BigInteger.valueOf(1));
    n = p.multiply(q); phi = p1.multiply(q1);
    e = BigInteger.valueOf(2);
    while (phi.compareTo(e) > 0 && (phi.mod(e).compareTo(BigInteger.ZERO) == 0))
    {if (GCD(e,phi).equals(BigInteger.ONE) == true){  break;}else  e = e.add(BigInteger.ONE);}
    int messageNumber = 42;
    int key = generateKey(100);
    while (key > n.intValue()){ generateKey(100);}
    k = new BigInteger(Integer.toString(key));
    BigInteger message = new BigInteger(Integer.toString(messageNumber));
    encrypt = (message.pow(e.intValue())).mod(n);
    d = BigInteger.valueOf(1); // e * d[x] mod phi == 1
    while ((e.multiply(d).mod(phi)).compareTo(BigInteger.ONE) == 1){      d = d.add(BigInteger.ONE);  }
    decrypt = (encrypt.pow(d.intValue())).mod(n);

    System.out.print("P\t=\t" + p);     System.out.println("\tQ\t=\t" + q);
    System.out.print("P--\t=\t" + p1);   System.out.println("\tQ--\t=\t" + q1);
    System.out.print("PHI\t=\t" + phi); System.out.println("\tN\t=\t" + n);
    System.out.print("e\t=\t" + e);   System.out.println("\td\t=\t" + d);
    System.out.println("k\t=\t" + k);
    System.out.println("message = " + message);
    System.out.println("encrypt : " +  encrypt);
    System.out.println("decrypt : " + decrypt);
  }
}
