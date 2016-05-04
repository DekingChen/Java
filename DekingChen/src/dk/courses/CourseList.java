package dk.courses;
import java.util.List;

import java.util.Iterator;

import java.util.ArrayList;

/**
 * @author Administrator
 * 课程列表类
 */
public class CourseList {
	public static  List<Course> courselist = new ArrayList<Course>();;//课程集合

	public CourseList() {}

	public List<Course> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<Course> courselist) {
		CourseList.courselist = courselist;
	}
	
	//添加课程
	public static void addCourse(String id, String name){
		Course c = new Course(id, name);
		System.out.println("添加了课程：\t"+"课程编号："+c.getId()+"\t"+"课程名称："+c.getName());
		courselist.add(c);
		
	}
	
	//查询课程
	public static Course getCourse(String id){
		Iterator<Course> it = CourseList.courselist.iterator();
		while(it.hasNext()){
			Course c = it.next();
			if(c.getId()==id)
				return c;
		}
		return null;
	}
	
	//获取课程在集合中的索引
	public static int getCourseIndex(String id){
		int len = CourseList.courselist.size();
		for(int i=0; i<len;i++){
			Course c = CourseList.courselist.get(i);
			if(c.getId()==id)
				return i;
		}
		return -1;
	}
	
	//获取课程在集合中的索引
	public static int getCourseIndex(Course c){
		return CourseList.courselist.indexOf(c);
	}
	
	//修改课程
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
	
	//移除课程
	public static boolean removeCourse(String id){
		int index = getCourseIndex(id);
		if(index>=0){
			return CourseList.courselist.remove(index) != null;
		}
		return false;
	}
	
	//移除所有课程
	public static boolean removeAllCourse(){
		CourseList.courselist.clear();
		 return true;
		 //return this.courselist.removeAll(courselist);	
	}
	
	//获取所有课程
	public static void getAllCourse(){
		Iterator<Course> it = CourseList.courselist.iterator();
		show("=========================================================");
		show("课程列表如下：(共有"+CourseList.courselist.size()+"门课程)");
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
	
	//查找是否存在课程
	public static boolean containCourse(Course c){
		return CourseList.courselist.contains(c);
	}
	
}
