/**
 * 
 */
package dk.debug;

import dk.main.Show;

/**
 * @author Administrator
 *
 */
public class Example extends Show{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		show(getRuslt(6));
		
	}
	public static int getRuslt(int value){
		if(value==1)
			return value;
		else
			return value*getRuslt(value-1);
	}

}
