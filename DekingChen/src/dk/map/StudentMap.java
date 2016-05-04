package dk.map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dk.students.Student;

public class StudentMap {

	public Map<String, Student> students;
	private Scanner console;
	public StudentMap(){
		this.students = new HashMap<String, Student>();
	}
	
	//创建键值对
	public void putStudents(){
		console = new Scanner(System.in);
		int i = 0;
		while(i<3){
			System.out.println("请输入学生ID");
			String Id = console.next();
			Student st = this.students.get(Id);
			if(st==null){
				show("请输入学生的姓名");
				String Name = console.next();
				Student student = new Student(Id,Name);
				this.students.put(Id, student);
				show("成功添加了学生:"+students.get(Id).getName());
				i++;
			}else{
				show("该学生Id已被占用");
				continue;
			}
		}
	}
	
	//获取键值对
	public void getKeySet(){
		Set<String> keyset = students.keySet();
		show("总有"+students.size()+"个学生");
		for(String id:keyset){
			Student st = students.get(id);
			if(st!=null){
				show("学生："+st.getName());
			}
		}
	}
	
	//删除键值对
	public void removeKey(){
		while(true){
			show("请输入要删除学生的Id：");
			String Id = console.next();
			Student st = students.get(Id);
			if(st==null){
				show("学生信息不存在！");
				continue;
			}
			students.remove(Id);
			show("成功删除学生"+st.getName());
			break;
		}
	}
	
	//遍历集合
	public void printEntrySet(){
		Set<Entry<String, Student>> entryset = students.entrySet();
		for(Entry<String,Student>entry:entryset){
			show("取得的键值："+entry.getKey());
			show("取得的值："+entry.getValue().toString());
		}
	}
	
	//修改键值对
	public void setKey(){
		
		while(true){
			show("请输入要修改的学生Id：");
			String Id = console.next();
			Student st = students.get(Id);
			if(st==null){
				show("学生不存在，请重新输入");
				continue;
			}
			show("当前学生Id对应的学生姓名："+st.getName());
			show("请重新输入学生姓名：");
			String newName = console.next();
			Student nst = new Student(Id,newName);
			students.put(Id, nst);
			show("修改学生成功！");
			getKeySet();
			break;
			
		}
	}
	
	public void test(){
		students.containsValue(new Student(null,"001"));
	}
	
	public static void show(Object obj){
		System.out.println(obj.toString());
	}
}
