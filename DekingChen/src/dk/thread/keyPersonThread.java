package dk.thread;

public class keyPersonThread extends Thread {

	public void run(){
		show("��ʼս��������");
		for(int i=0;i<10;i++)
			show(Thread.currentThread().getName()+" ��ͻ��ɱ���������.....");
		show("����ս����");
	}
	public static void show(Object obj){
		System.out.println(obj);
	}
}
