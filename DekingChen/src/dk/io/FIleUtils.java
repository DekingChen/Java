package dk.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FIleUtils {

	private static RandomAccessFile raf;
	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("目录"+dir+"不存在！");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"不是目录！");
		}
		File[] list = dir.listFiles();
		if(list!=null&&list.length>0){
			for(File file:list){
				if(file.isDirectory())
				 listDirectory(file);
				show(file);
			}
		}
	}
	public static void writeOrreadFile(String pathorfile)throws IOException{
		raf = new RandomAccessFile(pathorfile,"rw");
		show(raf.getFilePointer());
		raf.write('A');
		show(raf.getFilePointer());
		raf.write('B');
		byte b[] = new byte[(int) raf.length()];
		raf.read(b);
		for(byte bb:b)
			show(bb+"ok");
	}
	
	public static void show(Object obj){
		System.out.println(obj.toString());
	}
	public static void show(){}
	
	public static void listArr(Object[] arr){
		for(Object obj:arr){
			show(obj.toString());
		}
	}
	public static void main(String[] args){
		String file_path = "F:\\WorkPlace\\file\\";
		try {
			//listDirectory(new File(file_path));
			writeOrreadFile(file_path+"index.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
