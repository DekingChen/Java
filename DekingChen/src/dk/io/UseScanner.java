/**
 * 
 */
package dk.io;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class UseScanner {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag ){
				String s = sc.nextLine();
				if(s.equals("exit")){
					flag = false;
					sc.close();
				}
				else
				System.out.println(s);
		}
		System.out.println("Hello Out");  
        System.err.println("Hello Error");  
        byte[] b = new byte[1024];  
        int count = System.in.read(b);  
        System.out.println(new String(b, 0, count));  

	}

}
