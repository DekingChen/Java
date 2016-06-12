package dk.socketApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public void Connet(String address , int port){
		try {
			//1.�����ͻ���Socket��ָ����������ַ
			Socket socket = new Socket(address,port);
			//2.��ȡ��������������������Ϣ
			OutputStream out  = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(out);
			pw.write("userName:admin;pwd:admin");
			pw.flush();
			//3.��ȡ������
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String contents = br.readLine();
			while(contents!=null){
				System.out.println("���ǿͻ��ˣ��������������ˣ�"+contents);
				contents = br.readLine();
			}
			br.close();
			in.close();
			socket.shutdownInput();
			out.close();
			pw.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		Client client = new Client();
		client.Connet("localhost", 8888);
	}
}
