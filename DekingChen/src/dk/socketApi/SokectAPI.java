/**
 * 
 */
package dk.socketApi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;


/**
 * @author Administrator
 *
 */
public class SokectAPI {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Server server = new Server();
		server.Connect(8888);
		Client client = new Client();
		client.Connet("localhost", 8888);
		TestInetAdress();
		
	}
	
	public static void TestSocket(){
		
	}
	
	public static void TestInetAdress(){
		//InetAdress类的使用
		try {
			InetAddress address = InetAddress.getLocalHost();
			String Name = address.getHostName();
			String IP =  address.getHostAddress();
			byte[] list = address.getAddress();
			System.out.println("This host name:"+Name);
			System.out.println("This host IP:"+IP);
			System.out.println("This host IP:"+Arrays.toString(list));
			InetAddress address01 = InetAddress.getByName("KPHW7FTEKGVSZJ9");
			String Name01 = address01.getHostName();
			String IP01 = address01.getHostAddress();
			System.out.println(Name01);
			System.out.println(IP01);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	
	public static void Show(Object obj){
		System.out.println(obj);
	}
	
	public static void show(Object obj){
		System.out.println(obj);
	}
	
	public static void TestURL() throws Exception{
		//URL类的使用
		URL url = new URL("http://www.imooc.com/");
		URL imooc = new URL(url,"index.html?username=DK&&pwd=120");
		Show(url.getProtocol());
		Show(url.getHost());
		Show(url.getPort());
		Show(imooc.getHost());
		Show(url);
		show(imooc.getQuery());
		
		String baidu = "http://www.baidu.com";
		
		URL getBaidu = new URL(baidu);
		InputStream in = getBaidu.openStream();
		InputStreamReader inr = new InputStreamReader(in,"utf-8");
		BufferedReader br = new BufferedReader(inr);
		String s = br.readLine();
		while(s!=null){
			show(s);
			s = br.readLine();
		}
		
	}
}
