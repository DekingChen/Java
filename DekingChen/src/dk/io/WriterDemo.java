/**
 * 
 */
package dk.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * @author Administrator
 *
 */
public class WriterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path01 = "F:\\Java\\Data\\king.txt";
		String path02 = "F:\\Java\\Data\\count_test.txt";
		String path03 = "F:\\Java\\Data\\student.txt";
		String list[] = {path01,path02,path03};
		String path = "F:\\Java\\Data\\data.txt";
		readFile(path);
		useStreamTokenizer("F:\\Java\\Data\\test.txt");
		readFileByBuffer(path,list);
	
	}
	
	public static void readFile(String path){
		// TODO自动生成的方法存根  
	    char[] buffer=new char[512];   //一次取出的字节数大小,缓冲区大小  
	    int numberRead=0;  
	    FileReader reader=null;        //读取字符文件的流  
	    PrintWriter writer=null;    //写字符到控制台的流  
	     
	    try {  
	       reader=new FileReader(path);  
	       writer=new PrintWriter(System.out);  //PrintWriter可以输出字符到文件，也可以输出到控制台  
	       while ((numberRead=reader.read(buffer))!=-1) {  
	          writer.write(buffer, 0, numberRead);  
	       }  
	    } catch (IOException e) {  
	       // TODO自动生成的 catch 块  
	       e.printStackTrace();  
	    }finally{  
	       try {  
	          reader.close();  
	       } catch (IOException e) {  
	          // TODO自动生成的 catch 块  
	          e.printStackTrace();  
	       }  
	       writer.close();       //这个不用抛异常  
	    }  
	        
	}  
	
	public static void readFileByBuffer(String path,String fileName[]){
		  String str;  
		     //构建对该文件您的输入流  
		     BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(path));
			} catch (IOException e1) {
				e1.printStackTrace();
			}  
		     for(String name: fileName){  
		        BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(name));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}  
		         
		        try {
					while ((str=reader.readLine())!=null) {  
						System.out.println(str);
					   writer.write(str);  
					   //writer.newLine();  
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}  
		     } 
		    
	 } 
	
	//统计字符信息
	public static int useStreamTokenizer(String path){
		FileReader fileReader = null;  
        try {  
            fileReader = new FileReader(path);  
            //创建分析给定字符流的标记生成器  
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(fileReader));  
   
            //ordinaryChar方法指定字符参数在此标记生成器中是“普通”字符。  
            //下面指定单引号、双引号和注释符号是普通字符  
            st.ordinaryChar('\'');  
            st.ordinaryChar('\"');  
            st.ordinaryChar('/');  
   
            String s;  
            int numberSum = 0;  
            int wordSum = 0;  
            int symbolSum = 0;  
            int total = 0;  
            //nextToken方法读取下一个Token.  
            //TT_EOF指示已读到流末尾的常量。  
            while (st.nextToken() !=StreamTokenizer.TT_EOF) {  
                //在调用 nextToken 方法之后，ttype字段将包含刚读取的标记的类型  
                switch (st.ttype) {  
                //TT_EOL指示已读到行末尾的常量。  
                case StreamTokenizer.TT_EOL:  
                    break;  
                //TT_NUMBER指示已读到一个数字标记的常量  
                case StreamTokenizer.TT_NUMBER:  
                    //如果当前标记是一个数字，nval字段将包含该数字的值  
                    s = String.valueOf((st.nval));  
                    System.out.println("数字有："+s);  
                    numberSum ++;  
                    break;  
                //TT_WORD指示已读到一个文字标记的常量  
                case StreamTokenizer.TT_WORD:  
                    //如果当前标记是一个文字标记，sval字段包含一个给出该文字标记的字符的字符串  
                    s = st.sval;  
                    System.out.println("单词有： "+s);  
                    wordSum ++;  
                    break;  
                default:  
                    //如果以上3中类型都不是，则为英文的标点符号  
                    s = String.valueOf((char) st.ttype);  
                    System.out.println("标点有： "+s);  
                    symbolSum ++;  
                }  
            }  
            System.out.println("数字有 " + numberSum+"个");  
            System.out.println("单词有 " + wordSum+"个");  
            System.out.println("标点符号有： " + symbolSum+"个");  
            total = symbolSum + numberSum +wordSum;  
            System.out.println("Total = " + total);  
            return total;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return -1;  
        } finally {  
            if (fileReader != null) {  
                try {  
                    fileReader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
	}
}


