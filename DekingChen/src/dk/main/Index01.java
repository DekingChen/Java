/**
 * 
 */
package dk.main;

import dk.map.StudentMap;

/**
 * @author Administrator
 *
 */
public class Index01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StudentMap map = new StudentMap();
		
		map.putStudents();
		map.getKeySet();
		map.setKey();
		//map.printEntrySet();
	}

}
