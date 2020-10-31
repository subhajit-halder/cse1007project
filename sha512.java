import java.io.*; 

import java.math.BigInteger;  

import java.security.MessageDigest;  

import java.security.NoSuchAlgorithmException;  

import java.util.*; 

 

          public class Main { 

  

            public static byte[] createChecksum(String filename) throws Exception { 

                InputStream fis =  new FileInputStream(filename); 

  

                byte[] buffer = new byte[1024]; 

                MessageDigest complete = MessageDigest.getInstance("SHA-512"); 

                int numRead; 

  

                do { 

                    numRead = fis.read(buffer); 

                    if (numRead > 0) { 

                        complete.update(buffer, 0, numRead); 

                    } 

                } while (numRead != -1); 

  

                fis.close(); 

                return complete.digest(); 

            } 

  

            

            public static String getSHA512Checksum(String filename) throws Exception { 

                byte[] b = createChecksum(filename); 

                String result = ""; 

  

                for (int i=0; i < b.length; i++) { 

                    result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 ); 

                } 

                return result; 

            } 

  

         public static void main(String args[]) { 

             Scanner obj=new Scanner(System.in); 

             System.out.println("ENTER THE PATH OF THE FILE:"); 

                try { 

                    String path = obj.nextLine(); 

                    System.out.println(getSHA512Checksum (path)); 

                } 

                 

                catch (Exception e) { 

                    e.printStackTrace(); 

                } 

         } 

          

                } 
