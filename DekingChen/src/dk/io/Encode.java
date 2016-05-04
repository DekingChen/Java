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
		String s = "Ľ��ABC";
		show("============��ĿĬ�ϱ��룺gbk����=============================");
		byte[] b = s.getBytes();//�õ�����ĿĬ�ϵı���
		for(byte bb:b){
			toHex(bb);
		}
		show();
		show("============gbk���룬Ӣ��ռһ���ֽں�����ռ�����ֽڱ���===============");
		byte[] b1 = s.getBytes("gbk");
		for(byte bb:b1){
			toHex(bb);
		}
		show();
		show("============utf-8���룬Ӣ��ռһ���ֽں�����ռ�����ֽڱ���=============");
		byte[] b2 = s.getBytes("utf-8");
		for(byte bb:b2){
			toHex(bb);
		}
		show();
		show("============java��˫�ֽڱ��룬Ӣ�ĺ����Ķ��������ֽڱ���==============");
		byte[] b3 = s.getBytes("utf-16be");
		for(byte bb:b3){
			toHex(bb);
		}
	}
}
