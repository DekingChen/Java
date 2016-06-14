/**
 * 
 */
package dk.socketApi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Administrator
 *
 */
public class ServerThread extends Thread {

	Socket socket = null;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream out = null;
		PrintWriter pw = null;
		ObjectOutputStream objwrite = null;
		ObjectInputStream  objread = null;
		try {
			//3.��ȡ����������ȡ�ͻ��˵���Ϣ
			is = socket.getInputStream();
			/*isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String contents = br.readLine();
			while(contents!=null){
				System.out.println("���Ƿ��������ͻ��˷������ˣ�"+contents+"ID=="+this.getName());
				contents = br.readLine();
			}*/
			
			objread = new ObjectInputStream(new BufferedInputStream(is));
			User user = null;
			try {
				user = (User)objread.readObject();
				if(user!=null){
					System.out.println(user.toString());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		/*	try {
				while((user = (User) objread.readObject() ) != null){
					 System.out.println(user.toString());
				}
				//�ر�������
				socket.shutdownInput();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}*/
			//4.��ȡ��������ͻ��˷�����Ϣ
			/*out = socket.getOutputStream();
			pw = new PrintWriter(out);
			pw.write("Fuck your mother ,Client!"+this.getName());
			pw.flush();*/
			out = socket.getOutputStream();
			objwrite = new ObjectOutputStream(out);
			Admin admin = new Admin("Jame","Wellcome,My Friends!");
			objwrite.writeObject(admin);
			//objwrite.writeObject(null);
			objwrite.flush();
			socket.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				//�ر������
				if(objread!= null){
					objread.close();
				}
				if(objwrite!=null){
					objwrite.close();
				}
				if(pw!=null)
					pw.close();
				if(out!=null)
					out.close();
				//�ر�������
				if(br!=null)
					br.close();
				if(isr!=null)
					isr.close();
				if(is!=null)
					is.close();
				if(socket!=null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}


