/**
 * 
 */
package dk.hex;

import dk.main.Show;

/**
 * @author Administrator
 *
 */
public class UseHex extends Show{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		useBinary();
		useOctal();
	}
	
	public static void useBinary(){
		int n  = 57 ;
		String b = Integer.toBinaryString(n);
		String hex = Integer.toHexString(n);
		String octal = Integer.toOctalString(n);
		show(b);
		show(hex);
		show(octal);
	}
	
	public static void useOctal(){
		int b = Integer.parseInt("1010", 2);
		int octal = Integer.parseInt("77", 8);
		int hex = Integer.parseInt("77", 16);
		show(b);
		show(octal);
		show(hex);
	}
	
	public static void useDecimal (){
		int b = Integer.parseInt("1010", 2);
		int octal = Integer.parseInt("77", 8);
		int hex = Integer.parseInt("77", 16);
		show(b);
		show(octal);
		show(hex);
	}

}
