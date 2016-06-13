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
			//1.创建一个Socket，并绑定端口，监听端口
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(port);
			int count = 0;
			//2.调用accept方法开始监听端口，等待客户端连接
			System.out.println("****服务器即将启动，等待客户端连接****");
			Socket socket = null;
			//循环读取Socket通信信息
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

