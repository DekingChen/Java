/**
 * 
 */
package dk.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class InputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String path = "F:\\Java\\Data\\data.txt";
		String path01 = "F:\\Java\\Data\\king.txt";
		//String path02 = "F:\\Java\\Data\\count_test.txt";
		//String path03 = "F:\\Java\\Data\\student.txt";
		countFile(path01);
		//copyFile(path02,path01);
		//readObj(path02);
	}
	
	public static void countFile(String path){
		int count = 0;
		FileInputStream reader = null;
		BufferedInputStream buffer = null;
		InputStreamReader char_reader = null;
		BufferedReader char_reader_buffer = null;
		try {
			reader = new FileInputStream(new File(path));
			buffer = new BufferedInputStream(reader);
			char_reader = new InputStreamReader(reader);
			char_reader_buffer = new BufferedReader(char_reader);
			try {
				while(reader.read()!= -1){
					count++;
				}
				
				byte[] b = new byte[2];
				while((buffer.read(b))!= -1){
					System.out.println(new String(b));
				}
				char[] c = new char[1];
				
				while(( char_reader.read(c))!=-1){
					System.out.println(new String(c));
				}
				String s = null;
				while((s = char_reader_buffer.readLine())!=null){
					System.out.println(s);
				}
 				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("字节长度是： "+count+" 字节"); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	//字节数据读取数据
	public static void copyFile(String orginal , String destination){
		// TODO自动生成的方法存根  
	     byte[] buffer=new byte[100];   //一次取出的字节数大小,缓冲区大小  
	     int numberRead=0;  
	     FileInputStream input=null;  
	     FileOutputStream out =null;  
	     try {
			input = new FileInputStream(orginal);  
			 out = new FileOutputStream(destination);
			 try {
				while ((numberRead=input.read(buffer))!=-1) {  //numberRead的目的在于防止最后一次读取的字节小于buffer长度，  
					String s  = new String(buffer);
					System.out.println("===========================");
					System.out.println(s);
				    out.write(buffer, 0, numberRead);       //否则会自动被填充0 
				    }
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				input.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//读取对象流
	public static void readObj(String path){
		  ObjectOutputStream objectwriter = null;  
	      ObjectInputStream  objectreader = null;  
	      try {
			objectwriter=new ObjectOutputStream(new FileOutputStream(path));
			objectwriter.writeObject(new Student("DK", 22));  
	        objectwriter.writeObject(new Student("czq", 18));  
	        objectwriter.writeObject(new Student("DekingChen", 17)); 
	        objectwriter.writeObject(null); //为了使最后一次读取对象时候不出现异常
	        objectreader=new ObjectInputStream(new FileInputStream(path));  
	         Student student = null;
	         try {
				while((student = (Student) objectreader.readObject())!=null){
					System.out.println(student.toString());
	            	System.out.println(student.getName());
				 }
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	         
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				objectwriter.close();
				objectreader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}


@SuppressWarnings("serial")
class Student implements Serializable{  
	   private String name;  
	   private int age;  
	    
	   public Student(String name, int age) {  
	      super();  
	      this.name = name;  
	      this.age = age;  
	   }  
	   
	   @Override  
	   public String toString() {  
	      return "Student [name=" + name + ", age=" + age + "]";  
	   }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}  
	   
	   
	    
	    
	}  
