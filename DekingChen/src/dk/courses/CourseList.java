package dk.courses;
import java.util.List;

import java.util.Iterator;

import java.util.ArrayList;

/**
 * @author Administrator
 * �γ��б���
 */
public class CourseList {
	public static  List<Course> courselist = new ArrayList<Course>();;//�γ̼���

	public CourseList() {}

	public List<Course> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<Course> courselist) {
		CourseList.courselist = courselist;
	}
	
	//��ӿγ�
	public static void addCourse(String id, String name){
		Course c = new Course(id, name);
		System.out.println("����˿γ̣�\t"+"�γ̱�ţ�"+c.getId()+"\t"+"�γ����ƣ�"+c.getName());
		courselist.add(c);
		
	}
	
	//��ѯ�γ�
	public static Course getCourse(String id){
		Iterator<Course> it = CourseList.courselist.iterator();
		while(it.hasNext()){
			Course c = it.next();
			if(c.getId()==id)
				return c;
		}
		return null;
	}
	
	//��ȡ�γ��ڼ����е�����
	public static int getCourseIndex(String id){
		int len = CourseList.courselist.size();
		for(int i=0; i<len;i++){
			Course c = CourseList.courselist.get(i);
			if(c.getId()==id)
				return i;
		}
		return -1;
	}
	
	//��ȡ�γ��ڼ����е�����
	public static int getCourseIndex(Course c){
		return CourseList.courselist.indexOf(c);
	}
	
	//�޸Ŀγ�
	public static boolean setCourse(String id, String name){
		int index = getCourseIndex(id);
		if(index>=0){
			Course c = CourseList.courselist.get(index);
			c.setName(name);
			CourseList.courselist.set(index, c);
			return true;
		}
		return false;
	}
	
	//�Ƴ��γ�
	public static boolean removeCourse(String id){
		int index = getCourseIndex(id);
		if(index>=0){
			return CourseList.courselist.remove(index) != null;
		}
		return false;
	}
	
	//�Ƴ����пγ�
	public static boolean removeAllCourse(){
		CourseList.courselist.clear();
		 return true;
		 //return this.courselist.removeAll(courselist);	
	}
	
	//��ȡ���пγ�
	public static void getAllCourse(){
		Iterator<Course> it = CourseList.courselist.iterator();
		show("=========================================================");
		show("�γ��б����£�(����"+CourseList.courselist.size()+"�ſγ�)");
		show("=========================================================");
		while(it.hasNext()){
			Course c = it.next();
			show(c.toString());
		}
		show("=========================================================");
	}
	
	public static void show(Object obj){
		System.out.println(obj.toString());
	}
	
	//�����Ƿ���ڿγ�
	public static boolean containCourse(Course c){
		return CourseList.courselist.contains(c);
	}
	
}
