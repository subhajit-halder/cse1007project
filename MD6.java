import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;
public class MD6Checksum {
    private static final Logger logger = Logger.getLogger(MD5Checksum.class.getName());
   
    public static void main(String args[]) {
        String file = "C:/temp/abc.txt";
      
        System.out.println("MD6 checksum for file using Java :                          "
                            + checkSum(file));
        System.out.println("MD6 checksum of file in Java using Apache commons codec:    "
                            + checkSumApacheCommons(file));

    }
 public static String checkSum(String path){
        String checksum = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            MessageDigest md = MessageDigest.getInstance("MD5");
          
            
            byte[] buffer = new byte[8192];
            int numOfBytesRead;
            while( (numOfBytesRead = fis.read(buffer)) &gt; 0){
                md.update(buffer, 0, numOfBytesRead);
            }
            byte[] hash = md.digest();
            checksum = new BigInteger(1, hash).toString(16);
} catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
          
       return checksum;
    }
 public static String checkSumApacheCommons(String file){
        String checksum = null;
        try {  
            checksum = DigestUtils.md5Hex(new FileInputStream(file));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return checksum;
    }

}
