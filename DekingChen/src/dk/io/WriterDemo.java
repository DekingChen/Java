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
		// TODO�Զ����ɵķ������  
	    char[] buffer=new char[512];   //һ��ȡ�����ֽ�����С,��������С  
	    int numberRead=0;  
	    FileReader reader=null;        //��ȡ�ַ��ļ�����  
	    PrintWriter writer=null;    //д�ַ�������̨����  
	     
	    try {  
	       reader=new FileReader(path);  
	       writer=new PrintWriter(System.out);  //PrintWriter��������ַ����ļ���Ҳ�������������̨  
	       while ((numberRead=reader.read(buffer))!=-1) {  
	          writer.write(buffer, 0, numberRead);  
	       }  
	    } catch (IOException e) {  
	       // TODO�Զ����ɵ� catch ��  
	       e.printStackTrace();  
	    }finally{  
	       try {  
	          reader.close();  
	       } catch (IOException e) {  
	          // TODO�Զ����ɵ� catch ��  
	          e.printStackTrace();  
	       }  
	       writer.close();       //����������쳣  
	    }  
	        
	}  
	
	public static void readFileByBuffer(String path,String fileName[]){
		  String str;  
		     //�����Ը��ļ�����������  
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
	
	//ͳ���ַ���Ϣ
	public static int useStreamTokenizer(String path){
		FileReader fileReader = null;  
        try {  
            fileReader = new FileReader(path);  
            //�������������ַ����ı��������  
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(fileReader));  
   
            //ordinaryChar����ָ���ַ������ڴ˱�����������ǡ���ͨ���ַ���  
            //����ָ�������š�˫���ź�ע�ͷ�������ͨ�ַ�  
            st.ordinaryChar('\'');  
            st.ordinaryChar('\"');  
            st.ordinaryChar('/');  
   
            String s;  
            int numberSum = 0;  
            int wordSum = 0;  
            int symbolSum = 0;  
            int total = 0;  
            //nextToken������ȡ��һ��Token.  
            //TT_EOFָʾ�Ѷ�����ĩβ�ĳ�����  
            while (st.nextToken() !=StreamTokenizer.TT_EOF) {  
                //�ڵ��� nextToken ����֮��ttype�ֶν������ն�ȡ�ı�ǵ�����  
                switch (st.ttype) {  
                //TT_EOLָʾ�Ѷ�����ĩβ�ĳ�����  
                case StreamTokenizer.TT_EOL:  
                    break;  
                //TT_NUMBERָʾ�Ѷ���һ�����ֱ�ǵĳ���  
                case StreamTokenizer.TT_NUMBER:  
                    //�����ǰ�����һ�����֣�nval�ֶν����������ֵ�ֵ  
                    s = String.valueOf((st.nval));  
                    System.out.println("�����У�"+s);  
                    numberSum ++;  
                    break;  
                //TT_WORDָʾ�Ѷ���һ�����ֱ�ǵĳ���  
                case StreamTokenizer.TT_WORD:  
                    //�����ǰ�����һ�����ֱ�ǣ�sval�ֶΰ���һ�����������ֱ�ǵ��ַ����ַ���  
                    s = st.sval;  
                    System.out.println("�����У� "+s);  
                    wordSum ++;  
                    break;  
                default:  
                    //�������3�����Ͷ����ǣ���ΪӢ�ĵı�����  
                    s = String.valueOf((char) st.ttype);  
                    System.out.println("����У� "+s);  
                    symbolSum ++;  
                }  
            }  
            System.out.println("������ " + numberSum+"��");  
            System.out.println("������ " + wordSum+"��");  
            System.out.println("�������У� " + symbolSum+"��");  
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


