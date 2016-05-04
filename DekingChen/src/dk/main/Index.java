package dk.main;

import dk.courses.Course;
import dk.courses.CourseList;
import dk.students.Student;

public class Index {
	public static void main(String[] args){
		//CourseList list = new CourseList();
		CourseList.show("开始添加课程");
		CourseList.show("=========================================================");
		CourseList.addCourse("001","Java课程设计");
		CourseList.addCourse("002","数据结构");
		CourseList.addCourse("003","高等数学");
		CourseList.addCourse("004","Java课程设计");
		CourseList.addCourse("005","计算机网络基础");
		CourseList.getAllCourse();
		CourseList.setCourse("001", "C语言程序设计");
		CourseList.getAllCourse();
		Course c = CourseList.getCourse("002");
		Course c1 = new Course("0088",c.getName());
		CourseList.show(CourseList.getCourseIndex(c1));
		//Course c = CourseList.getCourse("001");
		//Course c1 = new Course(c.getId(),c.getName());
		CourseList.show(CourseList.containCourse(c1));
		CourseList.removeCourse("004");
		//CourseList.removeAllCourse();
		CourseList.show(c.toString());
		CourseList.getAllCourse();
		Student s = new Student("007","DekingChen");
		s.selectCourses("001");
		s.selectCourses("002");
		s.selectCourses("003");
		s.selectCourses("005");
		s.removeCourse("003");
		s.printCourses();
		
		
	}
}
