import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class sha256 {

    public static String digestoffile(String filepath) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
        String hex = checksum(filepath, md);
        return hex;
    }
          
    public static String checksum(String filepath, MessageDigest md) throws Exception {

        try (DigestInputStream dis = new DigestInputStream(new FileInputStream(filepath), md)) {
            while (dis.read() != -1) ; 
            md = dis.getMessageDigest();
        }

        StringBuilder result = new StringBuilder();
        for (byte b : md.digest()) {
            result.append(String.format("%02x", b));
        }
        return result.toString();

    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the file path");
        try{
            String filepath=in.nextLine();
            System.out.println(".");
            System.out.println(".");
            System.out.println("SHA-256 hash for the above file is :");
            System.out.println(digestoffile(filepath));
            System.out.println(".");
            System.out.println(".");

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
