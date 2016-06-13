package dk.socketApi;

import java.io.IOException;
import java.net.InetAddress;
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
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(port);
			int count = 0;
			//2.����accept������ʼ�����˿ڣ��ȴ��ͻ�������
			System.out.println("****�����������������ȴ��ͻ�������****");
			Socket socket = null;
			//ѭ����ȡSocketͨ����Ϣ
			while(true){
				socket = server.accept();
				ServerThread serverthread = new ServerThread(socket);
				serverthread.start();
				System.out.println("Count is " + count);
				count++;
				InetAddress address = socket.getInetAddress();
				System.out.println("IP : "+address.getHostAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		Server server = new Server();
		server.Connect(8888);
	}
}

