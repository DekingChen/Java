/**
 * 
 */
package dk.socketApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Administrator
 *
 */
public class ServerThread extends Thread {

	Socket socket = null;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream out = null;
		PrintWriter pw = null;
		try {
			//3.获取输入流，读取客户端的信息
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String contents = br.readLine();
			while(contents!=null){
				System.out.println("我是服务器，客户端发送来了："+contents+"ID=="+this.getName());
				contents = br.readLine();
			}
			//关闭输入流
			socket.shutdownInput();
			//4.获取输出流给客户端发送信息
			out = socket.getOutputStream();
			pw = new PrintWriter(out);
			pw.write("Fuck your mother ,Client!"+this.getName());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				//关闭输出流
				if(pw!=null)
					pw.close();
				if(out!=null)
					out.close();
				//关闭输入流
				if(br!=null)
					br.close();
				if(isr!=null)
					isr.close();
				if(is!=null)
					is.close();
				if(socket!=null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
