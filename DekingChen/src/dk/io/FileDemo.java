package dk.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	public static void main(String args[]){
		String file_path = "F:\\WorkPlace\\file\\";
		File file = new File(file_path);
		if(!file.exists()){
			file.mkdir();//����Ŀ¼
		}else{
			file.delete();//ɾ��Ŀ¼
		}
		show(file.isDirectory());//�ж��Ƿ�ΪĿ¼
		show(file.isFile());//�ж��Ƿ�Ϊ�ļ�
		file_path = file_path+"index.txt";
		File file01 = new File(file_path);//�����ļ�
		if(!file01.exists()){
			try {
				file01.createNewFile();//�����ļ�
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
