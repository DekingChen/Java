package dk.socketApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * @author Administrator
 *
 */
public class Server {

	public void Connect(int port ){
		try {
			port = (port > 0 && port<6553)?port:8888;
			//1.����һ��Socket�����󶨶˿ڣ������˿�
			ServerSocket server = new ServerSocket(port);
			//2.����accept������ʼ�����˿ڣ��ȴ��ͻ�������
			System.out.println("****�����������������ȴ��ͻ�������****");
			Socket socket = server.accept();
			//3.��ȡ����������ȡ�ͻ��˵���Ϣ
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br =new BufferedReader(isr);
			String contents = br.readLine();
			while(contents!=null){
				System.out.println("���Ƿ��������ͻ��˷������ˣ�"+contents);
				contents = br.readLine();
			}
			//4.��ȡ��������ͻ��˷�����Ϣ
			OutputStream out = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(out);
			pw.write("Fuck your mother ,Client!");
			pw.flush();
			out.close();
			pw.close();
			is.close();
			isr.close();
			br.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Response(String Contents){
		
	}
	
	public static void main(String args[]){
		Server server = new Server();
		server.Connect(8888);
	}
}

