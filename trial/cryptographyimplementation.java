import java.util.Random;
import java.math.*;
public class cryptographyimplementation
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
    if (b.equals(0)) return a; return GCD(b,a.mod(b));
  }

  public static void main (String[] args)
  {
    //int range,p,q,n,e,phi,d,k,message,encrypt,decrypt;
    BigInteger p,q,n,e,p1,q1,phi,d,k,message,encrypt,decrypt; int range,value1,value2;
    range = 10; value1 = generateKey(range); value2 = generateKey(range);
    while (value1 == value2)  { value1 = generateKey(range); value2 = generateKey(range);}
    p = BigInteger.valueOf(value1); q = BigInteger.valueOf(value2);
    p1 = p.subtract(BigInteger.valueOf(1)); q1 = q.subtract(BigInteger.valueOf(1));
    n = p.multiply(q); phi = p1.multiply(q1);
    System.out.println("P\t=\t" + p);     System.out.println("Q\t=\t" + q);
    System.out.println("P1\t=\t" + p1);   System.out.println("Q1\t=\t" + q1);
    System.out.println("PHI\t=\t" + phi); System.out.println("N\t=\t" + n);

    // e = 2;
    // k = 2;
    e = BigInteger.valueOf(2);
     while ( e.intValue() < phi.intValue())
     { if (GCD(e,phi).equals(1)) { break; } else e.add(BigInteger.ONE);}
    // d = ((k*phi) + 1) / e;
    // System.out.println("p \t=\t " + p); System.out.println("q \t=\t " + q);
    // System.out.println("n \t=\t " + n); System.out.println("phi \t=\t " + phi);
    // System.out.println("e \t=\t " + e); System.out.println("d \t=\t " + d);
    // message = generateKey(n - 1);
    // System.out.println("\nmessage \t=\t " + message);
    // encrypt = ((int)Math.pow(message,e)) % n;
    // System.out.println("\n\tencrypt message as : " + encrypt);
    // decrypt = (int)Math.pow(encrypt,d) % n;
    // System.out.println("\n\tdecrypt message as : " + decrypt);
  }















}
