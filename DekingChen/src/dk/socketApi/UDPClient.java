package dk.socketApi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public void Connet(String address , int port) throws IOException{
		//1.����������ĵ�ַ�����͵�����
		InetAddress address1 = InetAddress.getByName("localhost");
		byte[] data = "I am Client:DekingChen".getBytes();
		//2.�������ݱ����������͵���Ϣ
		DatagramPacket packet = new DatagramPacket(data,data.length,address1,port);
		//3.����DatagramSocket����
		@SuppressWarnings("resource")
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		//���ܷ���˵���Ӧ����
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
