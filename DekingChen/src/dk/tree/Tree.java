package dk.tree;


import java.util.TreeSet;

import dk.main.Show;

public class Tree extends Show{

	public static void mian(String [] args){
		TreeSet<Student> ts  = new TreeSet<Student>();
		ts.add(new Student("lisi0",30));
        ts.add(new Student("lisixx",29));
        ts.add(new Student("lisi9",29));
        ts.add(new Student("lisi8",38));
        ts.add(new Student("lisixx",29));
        ts.add(new Student("lisi4",14));
        //ts.add(new Student(39));
        ts.add(new Student("lisi7",27));
        show("Start...");
        for(Student s:ts){
        	show(s.getAge());
        }
	}
}
//同姓名同年龄的学生视为同一个学生。按照学生的年龄排序。
class Student implements Comparable<Object>
{
  private int age;
  private String name;
  Student(String name,int age)
  {
      this.age = age;
      this.name = name;
  }

  public int compareTo(Object obj)
  {
      
      Student stu = (Student)obj;
      
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



