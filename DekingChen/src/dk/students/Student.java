package dk.students;

import java.util.ArrayList;

import dk.courses.Course;
import dk.courses.CourseList;



/**
 * @author Administrator
 * ѧ����
 */
public class Student implements Comparable<Student>{
	private String id;
	private String name;
	private ArrayList<String> courses;//����γ̱��
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
	
	//ѡ��γ�
	public boolean selectCourses(String id){
			if(CourseList.getCourseIndex(id)==-1){
				CourseList.show("�γ̲����ڣ�");
				return false;
			}
			Course c = CourseList.getCourse(id);
			
			show("��ѡ�������¿γ̣�");
			show(c.toString());
	     	return this.courses.add(id);
	}
	
	//��ȡ�γ���Ϣ
	public void printCourses(){
		show("=========================================================");
		show(this.toString());
		show("=========================================================");
		show("�α�����:");
		for(String id:this.courses){
			Course c = CourseList.getCourse(id);
			show(c.toString());
		}
		show("=========================================================");
	}
	
	//ɾ���γ�
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
		return "ѧ�ţ�"+this.getId()+"\t������"+this.getName()+"\t��ѡ������"+this.courses.size()+"��";
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
