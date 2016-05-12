/**
 * 
 */
package dk.annotation;

/**
 * @author Administrator
 *
 */
@Description()
public class Student extends Person{

	
	public Student(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
	public void sing(String name){
		show();
	}
	@Description(author = "Deking", desc = "Java Annotation" ,age=24)
	public String  getMsg(){
		@Description()
		String sex = "BOY";
		return "Nothing:"+sex;
	}

}
