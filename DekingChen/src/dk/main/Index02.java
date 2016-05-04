package dk.main;

import java.util.List;
import java.util.Random;

import dk.students.Student;

import java.util.ArrayList;
import java.util.Collections;

public class Index02 {
	
	public static void main(String[] args){
		sortStudent();
	}
	public static void show(Object obj){
		System.out.println(obj.toString());
	}
	
	public static void sortStudent(){
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("6","Dk"));
		students.add(new Student("2","czq"));
		students.add(new Student("4","chenzhenquan"));
		students.add(new Student("3","DekingChen"));
		show("================排序前===================");
			for(Student s:students){
				show("学生=="+s.getName());
			}
		show("================排序后(按照Id排序)===================");
		Collections.sort(students);
		for(Student s:students){
			show("学生=="+s.getName());
		}
		show("================排序后(按照Name排序)===================");
		Collections.sort(students,new Index03());
		for(Student s:students){
			show("学生=="+s.getName());
		}
	}
	
	public static void sortInteger(){
		List<Integer> intlist = new ArrayList<Integer>();
		Random random = new Random();
		Integer k;
		for(int i=0;i<10;i++){
			do{
				k = random.nextInt(100);
			}while(intlist.contains(k));
			intlist.add(k);
		}
		show("================排序前===================");
		for(Integer i:intlist){
			show("元素："+i);
		}
		show("================排序后===================");
		Collections.sort(intlist);
		for(Integer i:intlist){
			show("元素："+i);
		}
	}
}
