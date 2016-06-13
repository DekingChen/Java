package dk.socketApi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UPDThread extends Thread {
	DatagramSocket socket = null;

	public UPDThread(DatagramSocket socket) {
		super();
		this.socket = socket;
	}
	
	public void run(){
		byte[] data = null;
		DatagramPacket packet = null;
		String info  = null;
		InetAddress address = null;
		int port_ = 0;
		byte[] data01 = null;
		DatagramPacket packet01 = null;
		try {
			//2.�����ֽ�����
			data = new byte[1024];
			packet = new DatagramPacket(data,data.length);
			socket.receive(packet);
			//4.��ȡ����
			info = new String(data,0,packet.getLength());
			System.out.println("Server has get :"+info);
			//5.��������Ӧ���ݸ��ͻ���
			address = packet.getAddress();
			port_ = packet.getPort();
			data01 = "Wellcome,My Friends!".getBytes();
			packet01 = new DatagramPacket(data01,0,data01.length,address,port_);
			socket.send(packet01);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(socket!=null)
				socket.close();
		}
	}
}
