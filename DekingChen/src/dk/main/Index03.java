/**
 * 
 */
package dk.main;

import java.util.Comparator;

import dk.students.Student;

/**
 * @author Administrator
 *
 */
public class Index03 implements Comparator<Student>{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
