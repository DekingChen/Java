package dk.main;

import dk.courses.Course;
import dk.courses.CourseList;
import dk.students.Student;

public class Index {
	public static void main(String[] args){
		//CourseList list = new CourseList();
		CourseList.show("��ʼ��ӿγ�");
		CourseList.show("=========================================================");
		CourseList.addCourse("001","Java�γ����");
		CourseList.addCourse("002","���ݽṹ");
		CourseList.addCourse("003","�ߵ���ѧ");
		CourseList.addCourse("004","Java�γ����");
		CourseList.addCourse("005","������������");
		CourseList.getAllCourse();
		CourseList.setCourse("001", "C���Գ������");
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
