/**
 * 
 */
package dk.lib;

//import java.io.BufferedInputStream;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import dk.main.Show;

/**
 * @author Administrator
 *
 */
public class ReaderProperties extends Show{
	
	public  Map<String,String> readProperties(String path){
		Properties props = new Properties();
		Map<String,String> map = new HashMap<String,String>();
		InputStream in = getClass().getResourceAsStream(path);//相对路径
		try {
			props.load(in);
			Enumeration<?> en = props.propertyNames();
			while(en.hasMoreElements()){
				String key = (String)en.nextElement();
				String property = props.getProperty(key);
				map.put(key, property);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	public  Map<String,String> getProperties(String path){
		Properties props = new Properties();
		Map<String,String> map = new HashMap<String,String>();
		try {
			props.load(new FileInputStream(path));//全路径
			Enumeration<?> en = props.propertyNames();
			while(en.hasMoreElements()){
				String key = (String)en.nextElement();
				String value = props.getProperty(key);
				map.put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public String getCurrentPath(){  
	       //取得根目录路径  
	       String rootPath=getClass().getResource("/").getFile().toString();  
	       //当前目录路径  
	       String currentPath1=getClass().getResource(".").getFile().toString();  
	       String currentPath2=getClass().getResource("").getFile().toString();  
	       //当前目录的上级目录路径  
	       String parentPath=getClass().getResource("../").getFile().toString();  
	          show(rootPath);
	          show(currentPath1);
	          show(currentPath2);
	          show(parentPath);
	       return rootPath;         
	   
	   }
	
	public static void main(String[] args){
		//Map<String,String> map = new ReaderProperties().readProperties("type.properties");
		Map<String,String> map = new ReaderProperties().getProperties("/F:/Java/DekingChen/bin/dk/lib/type.properties");
		Set<String> keys = map.keySet(); 
		for(String s:keys){
			System.out.println(s+"="+map.get(s));
		}
		new ReaderProperties().getCurrentPath();
	}
	
}
