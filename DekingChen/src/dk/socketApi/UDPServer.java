package dk.socketApi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	public void Connect(int port ) throws IOException{
		//1.创建服务端DatagramSocket，指定端口号
		DatagramSocket socket = new DatagramSocket(port);
		//2.创建字节数组
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data,data.length);
		//3.接受客户端的信息数据
		System.out.println("Server is starting......");
		socket.receive(packet);
		//4.读取数据
		String info = new String(data,0,packet.getLength());
		System.out.println("I am Server , I receive messages :"+info);
		
		//5.服务器响应数据给客户端
		InetAddress address = packet.getAddress();
		int port_ = packet.getPort();
		byte[] data01 = "Wellcome,My Friends!".getBytes();
		DatagramPacket packet01 = new DatagramPacket(data01,0,data01.length,address,port_);
		socket.send(packet01);
		socket.close();
 	}
	
	public void connectThread(int port) throws SocketException{
		DatagramSocket socket =  new DatagramSocket(port);
		while(true){
			UPDThread updthread = new UPDThread(socket);
			updthread.start();
		}
	}
	
	public static void main(String args[]) throws IOException{
		UDPServer server = new UDPServer();
		server.Connect(8888);
		//server.connectThread(8886);
	}
}
