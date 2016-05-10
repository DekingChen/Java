/**
 * 
 */
package dk.tree;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author Administrator
 *
 */
public class Treemap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person person1 = new Person("马先生", 55);  
		Person person2 = new Person("李先生", 96);  
		Person person3 = new Person("王小姐", 75);  
		TreeMap<Number, Person> map = new TreeMap<Number, Person>();  
		map.put(person1.getAge(), person1);  
		map.put(person2.getAge(), person2);  
		map.put(person3.getAge(), person3);  
		for (Iterator<Number> it = map.keySet().iterator(); it.hasNext();) {// 遍例集合  
			Person person = map.get(it.next());  
			System.out.println(person.getAge() + " " + person.toString());  
			}  

	}

}
//同姓名同年龄的学生视为同一个学生。按照学生的年龄排序。
class Person implements Comparable<Object>
{
private int age;
private String name;
Person(String name,int age)
{
    this.age = age;
    this.name = name;
}

public int compareTo(Object obj)
{
    
	Person stu = (Person)obj;
    
    int num = new Integer(this.age).compareTo(new Integer(stu.age));

    return num==0?this.name.compareTo(stu.name):num;
}

public int getAge()
{
    return age;
}
public String toString()
{
    return name+"::"+age;
}
}