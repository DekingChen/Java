/**
 * 
 */
package dk.test;

import java.util.HashSet;
import java.util.Set;


/**
 * @author Administrator
 *
 */
public class Index {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Person> set = new HashSet<Person>();
		Person p1 = new Person("��ɮ","pwd1",25);
		Person p2 = new Person("�����","pwd2",26);
		Person p3 = new Person("��˽�","pwd3",27);
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println("�ܹ���:"+set.size()+" ��Ԫ��!"); //������ܹ���:3 ��Ԫ��!
		for (Person person:set)
		{
		System.out.println(person);
		}
		p3.setAge(2); //�޸�p3������,��ʱp3Ԫ�ض�Ӧ��hashcodeֵ�����ı�
		set.remove(p3); //��ʱremove����������ڴ�й©
		set.add(p3); //������ӣ���Ȼ��ӳɹ�
		System.out.println("�ܹ���:"+set.size()+" ��Ԫ��!"); //������ܹ���:4 ��Ԫ��!
		for (Person person:set)
		{
		System.out.println(person);
		}
	}

}

class Person{
	private String name;
	private String pwd;
	private int age;
	public Person(String name, String pwd, int age){
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
