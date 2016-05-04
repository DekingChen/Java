package dk.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	public static void main(String args[]){
		String file_path = "F:\\WorkPlace\\file\\";
		File file = new File(file_path);
		if(!file.exists()){
			file.mkdir();//创建目录
		}else{
			file.delete();//删除目录
		}
		show(file.isDirectory());//判断是否为目录
		show(file.isFile());//判断是否为文件
		file_path = file_path+"index.txt";
		File file01 = new File(file_path);//构造文件
		if(!file01.exists()){
			try {
				file01.createNewFile();//创建文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			file01.delete();
		}
		show(file01.getName());
	}
	
	public static void show(Object obj){
		System.out.println(obj.toString());
	}
	public static void show(){}
}
