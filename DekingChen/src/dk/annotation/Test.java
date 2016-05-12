/**
 * 
 */
package dk.annotation;

import dk.main.Show;

/**
 * @author Administrator
 *
 */
public class Test extends Show{

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Student $student = new Student("DK",18);
		$student.make();
		String msg = $student.getMsg();
		show(msg);
	}

}
