package dk.socketApi;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public void Connet(String address , int port){
		OutputStream out = null;
		InputStream in = null;
		ObjectInputStream  objread = null;
		ObjectOutputStream objwrite = null;
		Socket socket = null;
		User user = null;
		Admin admin = null;
		try {
			//1.�����ͻ���Socket��ָ����������ַ
			socket = new Socket(address,port);
			//2.��ȡ��������������������Ϣ
			out  = socket.getOutputStream();//�ֽ������
			objwrite = new ObjectOutputStream(out);
			for(int i=0;i<10;i++){
				user = new User("chenzhenquan"+i,"password"+i);
				objwrite.writeObject(user);
			}
			objwrite.writeObject(null);
			objwrite.flush();
			
			//3.��ȡ������
			in = socket.getInputStream();
			objread = new ObjectInputStream(new BufferedInputStream(in));
			try {
				while((admin = (Admin) objread.readObject())!= null){
					admin.say();
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//�ر������
			try {
				if(objwrite!=null)
					objwrite.close();
				if(out!=null)
					out.close();
				//�ر�������
				if(objread!=null)
					objread.close();
				if(in!=null)
					in.close();
				if(socket!=null)
					socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String args[]){
		Client client = null;
		for(int i = 0;i<50;i++){
			client = new Client();
			client.Connet("localhost", 8888);
		}
	}
}
