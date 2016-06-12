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
			//1.创建一个Socket，并绑定端口，监听端口
			ServerSocket server = new ServerSocket(port);
			//2.调用accept方法开始监听端口，等待客户端连接
			System.out.println("****服务器即将启动，等待客户端连接****");
			Socket socket = server.accept();
			//3.获取输入流，读取客户端的信息
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br =new BufferedReader(isr);
			String contents = br.readLine();
			while(contents!=null){
				System.out.println("我是服务器，客户端发送来了："+contents);
				contents = br.readLine();
			}
			//4.获取输出流给客户端发送信息
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

