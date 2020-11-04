import java.util.*;
import java.math.BigInteger; 
import java.security.MessageDigest; 
 
public class GFG { 
    public static String encryptThisString(String input)
    { 
        try { 
           
            MessageDigest md = MessageDigest.getInstance("SHA-384"); 
  
            
            byte[] messageDigest = md.digest(input.getBytes()); 
  
           
            BigInteger no = new BigInteger(1, messageDigest); 
  
            
            String hashtext = no.toString(16); 
  
            
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            
            return hashtext; 
        } 
  
        catch (Exception e) { 
            throw new RuntimeException(e); 
        } 
    } 
  
    public static void main(String args[]) 
    { 

      Scanner obj=new Scanner(System.in);
      System.out.println("ENTER THE PATH OF THE FILE:"); 

                try { 

                    String path = obj.nextLine(); 

                    System.out.println(encryptThisString (path)); 

                } 

                catch (Exception e) { 

                    e.printStackTrace(); 
       System.out.println("HashCode Generated by SHA-384 for: "); 
  
        String plaintext1 = "Attacked by enemies"; 
        System.out.println("\n" + plaintext1 + " : " + encryptThisString(plaintext1)); 
  
        String plaintext2 = "Need for emergency"; 
        System.out.println("\n" + plaintext2 + " : " + encryptThisString(plaintext2)); 
    } 
} 
}
  
