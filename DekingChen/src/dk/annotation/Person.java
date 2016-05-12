/**
 * 
 */
package dk.annotation;

import dk.main.Show;

/**
 * @author Administrator
 *
 */
public class Person extends Show implements Skills{

	public String name;
	public int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void sing(String name){
		show("I can sing "+name);
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		
	}

	
	@Deprecated
	public void make() {
		// TODO Auto-generated method stub
		
	}
	

}
