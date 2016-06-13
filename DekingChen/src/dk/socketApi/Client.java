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
			//1.创建客户端Socket，指定服务器地址
			Socket socket = new Socket(address,port);
			//2.获取输出流，向服务器发送信息
			OutputStream out  = socket.getOutputStream();//字节输出流
			PrintWriter pw = new PrintWriter(out);
			pw.write("userName:admin;pwd:DekingChen");
			pw.flush();
			socket.shutdownOutput();
			//3.获取输入流
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String contents = br.readLine();
			while(contents!=null){
				System.out.println("我是客户端，服务器发送来了："+contents);
				contents = br.readLine();
			}
			//关闭输入流
			br.close();
			in.close();
			//关闭输出流
			pw.close();
			out.close();
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
