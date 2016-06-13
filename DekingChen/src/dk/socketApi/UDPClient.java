package dk.socketApi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public void Connet(String address , int port) throws IOException{
		//1.定义服务器的地址，发送的数据
		InetAddress address1 = InetAddress.getByName("localhost");
		byte[] data = "I am Client:DekingChen".getBytes();
		//2.创建数据报，包含发送的信息
		DatagramPacket packet = new DatagramPacket(data,data.length,address1,port);
		//3.创建DatagramSocket对象
		@SuppressWarnings("resource")
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		//接受服务端的响应数据
		byte[] data01 = new byte[1024];
		DatagramPacket packet01 = new DatagramPacket(data01,data01.length);
		socket.receive(packet01);
		String reply = new String(data01,0,data01.length);
		System.out.println("I am Client,I receive messages:"+reply);
	}
	public static void main(String args[]) throws IOException{
		UDPClient client = new UDPClient();
		client.Connet("localhost", 8886);
	}
}
