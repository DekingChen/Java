package dk.thread;

public class keyPersonThread extends Thread {

	public void run(){
		show("¿ªÊ¼Õ½¶·¡£¡£¡£");
		for(int i=0;i<10;i++)
			show(Thread.currentThread().getName()+" ×óÍ»ÓÒÉ±£¬¹¥»÷Ëå¾ü.....");
		show("½áÊøÕ½¶·£¡");
	}
	public static void show(Object obj){
		System.out.println(obj);
	}
}
