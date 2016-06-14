package dk.socketApi;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import dk.socket.MyServer;



/**
 * @author Administrator
 *
 */
public class Server {
    private final static Logger logger = Logger.getLogger(MyServer.class.getName());  

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
				if(socket!=null){
					ServerThread serverthread = new ServerThread(socket);
					serverthread.setPriority(4);//设置优先级，否则运行比较慢
					serverthread.start();
					System.out.println("You are  " + count+" online user!");
					count++;
					InetAddress address = socket.getInetAddress();
					System.out.println("IP : "+address.getHostAddress());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		Server server = new Server();
		server.ConnectByObj(8888);
	}
	
	public void ConnectByObj(int port){
		ServerSocket server = null;
		try {
			port = (port > 0 && port<6553)?port:8888;
			//1.创建一个Socket，并绑定端口，监听端口
			server = new ServerSocket(port);
			//2.调用accept方法开始监听端口，等待客户端连接
			System.out.println("****服务器即将启动，等待客户端连接****");
			Socket socket = null;
			//循环读取Socket通信信息
			while(true){
				socket  = server.accept();
				invoke(socket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void invoke(final Socket socket) throws IOException{
		new Thread(new Runnable(){
			public void run() {
				InputStream is = null;
				OutputStream out = null;
				ObjectOutputStream objwrite = null;
				ObjectInputStream  objread = null;
				Admin admin = null;
				try {
					//3.读入对象流
					is = socket.getInputStream();
					objread = new ObjectInputStream(new BufferedInputStream(is));
					User user = null;
					out = socket.getOutputStream();
					objwrite = new ObjectOutputStream(out);
					try {
						while((user = (User)objread.readObject())!= null){
							System.out.println(user.toString());
							//4.写入对象流
							admin = new Admin("Hi,"+user.getUserName()+" !I am Jame","Wellcome,My Friends!");
							objwrite.writeObject(admin);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}finally{
						objwrite.writeObject(null);
						objwrite.flush();
					}
				} catch (IOException e) {
				//	e.printStackTrace();
					logger.log(Level.SEVERE, null, e); 
				} finally{
					try {
						//关闭输出流
						if(objwrite!=null)
							objwrite.close();
						if(out!=null)
							out.close();
						//关闭输入流
						if(objread!=null)
							objread.close();
						if(is!=null)
							is.close();
						if(socket!=null)
							socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}).start();
	}
}

