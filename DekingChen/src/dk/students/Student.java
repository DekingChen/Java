package dk.students;

import java.util.ArrayList;

import dk.courses.Course;
import dk.courses.CourseList;



/**
 * @author Administrator
 * 学生类
 */
public class Student implements Comparable<Student>{
	private String id;
	private String name;
	private ArrayList<String> courses;//储存课程编号
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.courses = new ArrayList<String>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}
	
	//选择课程
	public boolean selectCourses(String id){
			if(CourseList.getCourseIndex(id)==-1){
				CourseList.show("课程不存在！");
				return false;
			}
			Course c = CourseList.getCourse(id);
			
			show("您选择了以下课程：");
			show(c.toString());
	     	return this.courses.add(id);
	}
	
	//获取课程信息
	public void printCourses(){
		show("=========================================================");
		show(this.toString());
		show("=========================================================");
		show("课表如下:");
		for(String id:this.courses){
			Course c = CourseList.getCourse(id);
			show(c.toString());
		}
		show("=========================================================");
	}
	
	//删除课程
	public boolean removeCourse(String id){
		int index = this.getIndex(id);
		if(index==-1){
			return false;
		}
		this.courses.remove(index);
		return 	true;
	}
	
	public int getIndex(String id){
		for(int i=0;i<this.courses.size();i++){
			if(this.courses.get(i)==id)
				return i;
		}
		return -1;
	}
	
	public String toString(){
		return "学号："+this.getId()+"\t姓名："+this.getName()+"\t共选择了门"+this.courses.size()+"课";
	}
	
	public static void show(Object obj){
		System.out.println(obj.toString());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int compareTo(Student o) {
		//return this.name.compareTo(o.name);
		return this.id.compareTo(o.id);
	}
	
}
