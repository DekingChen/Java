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
	
	//������ֵ��
	public void putStudents(){
		console = new Scanner(System.in);
		int i = 0;
		while(i<3){
			System.out.println("������ѧ��ID");
			String Id = console.next();
			Student st = this.students.get(Id);
			if(st==null){
				show("������ѧ��������");
				String Name = console.next();
				Student student = new Student(Id,Name);
				this.students.put(Id, student);
				show("�ɹ������ѧ��:"+students.get(Id).getName());
				i++;
			}else{
				show("��ѧ��Id�ѱ�ռ��");
				continue;
			}
		}
	}
	
	//��ȡ��ֵ��
	public void getKeySet(){
		Set<String> keyset = students.keySet();
		show("����"+students.size()+"��ѧ��");
		for(String id:keyset){
			Student st = students.get(id);
			if(st!=null){
				show("ѧ����"+st.getName());
			}
		}
	}
	
	//ɾ����ֵ��
	public void removeKey(){
		while(true){
			show("������Ҫɾ��ѧ����Id��");
			String Id = console.next();
			Student st = students.get(Id);
			if(st==null){
				show("ѧ����Ϣ�����ڣ�");
				continue;
			}
			students.remove(Id);
			show("�ɹ�ɾ��ѧ��"+st.getName());
			break;
		}
	}
	
	//��������
	public void printEntrySet(){
		Set<Entry<String, Student>> entryset = students.entrySet();
		for(Entry<String,Student>entry:entryset){
			show("ȡ�õļ�ֵ��"+entry.getKey());
			show("ȡ�õ�ֵ��"+entry.getValue().toString());
		}
	}
	
	//�޸ļ�ֵ��
	public void setKey(){
		
		while(true){
			show("������Ҫ�޸ĵ�ѧ��Id��");
			String Id = console.next();
			Student st = students.get(Id);
			if(st==null){
				show("ѧ�������ڣ�����������");
				continue;
			}
			show("��ǰѧ��Id��Ӧ��ѧ��������"+st.getName());
			show("����������ѧ��������");
			String newName = console.next();
			Student nst = new Student(Id,newName);
			students.put(Id, nst);
			show("�޸�ѧ���ɹ���");
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
