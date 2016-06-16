/**
 * 
 */
package dk.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Administrator
 *
 */
public class IOTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path01 = "F:\\Java\\Data\\king01.txt";
		writeFileByChar(path01);
		readFile(path01);
		readFileByChar(path01);

	}
	
	public static void readFile(String path) throws IOException{
		FileInputStream file = new FileInputStream(new File(path));
		BufferedInputStream buffer = new BufferedInputStream(file);
		byte b[] = new byte[1024];
		String s = "";
		while((buffer.read(b))!=-1){
			s = new String (b);
			System.out.println(s);
		}
		buffer.close();
		file.close();
	}
	
	public static void readFileByChar(String path) throws IOException{
		FileInputStream f = new FileInputStream(new File(path));
		InputStreamReader file = new InputStreamReader(f,"GBK");
		BufferedReader buffer = new BufferedReader(file);
		char c[] = new char[1024];
		String s = "";
		while(buffer.read(c)!=-1){
			s = new String(c);
			System.out.println(s);
		}
		buffer.close();
		file.close();
	}
	
	public static void writeFile(String path) throws IOException{
		String s = "DekingChen:陈镇权";
		byte b[] = s.getBytes();
		FileOutputStream out = new FileOutputStream(new File(path));
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		buffer.write(b);
		buffer.close();
		out.close();
		
	}
	
	public static void writeFileByChar(String path) throws IOException{
		String s = "DekingChen:陈镇权";
		FileOutputStream out = new FileOutputStream(new File(path));
		OutputStreamWriter fr = new OutputStreamWriter(out,"UTF-8");
		BufferedWriter bw = new BufferedWriter(fr);
		bw.write(s);
		bw.close();
		fr.close();
		out.close();
	}
	
}
