import java.util.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

class findchecksum {
	public static void main(String []args){
	Scanner in=new Scanner(System.in);
	int expression;
do
{
	System.out.println("enter the corresponding number for preferred algorithm");
	System.out.println("1 for sha-256");
	System.out.println("2 for sha-512");
	System.out.println("3 for pranav");
	System.out.println("4 for md5");
	System.out.println("5 to end loop");

    expression = in.nextInt();
	switch(expression) {
  case 1:
     //subhajit's code
    sha256.main(args);
    break;
  case 2:
    //ajin's code 
    sha512.main(args);			
    break;
  case 3:
   //pranav's code 
    Sha384.main(args);			
    break;
  case 4:
   //dhanunjay's code 
    md5.main(args);			
    break;  

}

    }while(expression<5); 
}
}
