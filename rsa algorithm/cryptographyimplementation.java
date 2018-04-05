import java.util.Random;
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
  public static  int GCD(int a, int b)
  { if (b==0) return a; return GCD(b,a%b);}

  public static void main (String[] args)
  {
    int range,p,q,n,e,phi,d,k,message,encrypt,decrypt;
    range = 10;
    p = generateKey(range);
    q = generateKey(range);
    while (p == q)  { p = generateKey(range); q = generateKey(range);}
    n = p * q;  phi = (p - 1) * (q - 1);  e = 2; k = 2;
    while ( e < phi){ if (GCD(e,phi) == 1) { break; } else e++;}
    d = ((k*phi) + 1) / e;
    System.out.println("p \t=\t " + p); System.out.println("q \t=\t " + q);
    System.out.println("n \t=\t " + n); System.out.println("phi \t=\t " + phi);
    System.out.println("e \t=\t " + e); System.out.println("d \t=\t " + d);
    message = generateKey(n - 1);
    System.out.println("\nmessage \t=\t " + message);
    encrypt = ((int)Math.pow(message,e)) % n;
    System.out.println("\n\tencrypt message as : " + encrypt);
    decrypt = (int)Math.pow(encrypt,d) % n;
    System.out.println("\n\tdecrypt message as : " + decrypt);
  }















}
