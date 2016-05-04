package dk.thread;

public class ArmyRunnable implements Runnable {

	volatile boolean keepRunning = true;
	@Override
	public void run() {
		while(keepRunning){
			for(int i=0;i<5;i++){
				show(Thread.currentThread().getName()+"½ø¹¥¶Ô·½¡¾"+i+"¡¿");
				Thread.yield();
			}
		}

	}
	
	public static void show(Object obj){
		System.out.println(obj);
	}

}
