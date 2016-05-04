package dk.io;

public class Encode{

	public static void show(Object obj){
		System.out.println(obj.toString());
	}
	public static void show(){
		System.out.println();
	}
	public static void toHex(byte b){
		System.out.print(Integer.toHexString(b & 0xff)+" ");
		System.out.print(Integer.toHexString(b )+" ");
	}
	
	public static void main(String args[])  throws Exception{
		String s = "慕课ABC";
		show("============项目默认编码：gbk编码=============================");
		byte[] b = s.getBytes();//用的是项目默认的编码
		for(byte bb:b){
			toHex(bb);
		}
		show();
		show("============gbk编码，英文占一个字节和中文占两个字节编码===============");
		byte[] b1 = s.getBytes("gbk");
		for(byte bb:b1){
			toHex(bb);
		}
		show();
		show("============utf-8编码，英文占一个字节和中文占三个字节编码=============");
		byte[] b2 = s.getBytes("utf-8");
		for(byte bb:b2){
			toHex(bb);
		}
		show();
		show("============java是双字节编码，英文和中文都是两个字节编码==============");
		byte[] b3 = s.getBytes("utf-16be");
		for(byte bb:b3){
			toHex(bb);
		}
	}
}
