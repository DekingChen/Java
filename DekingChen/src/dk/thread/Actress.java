package dk.thread;

public class Actress implements Runnable {

	@Override
	public void run(){
		show(Thread.currentThread().getName()+" is a actor!");
		int count = 0;
		boolean keep = true;
		while(keep){
			show(Thread.currentThread().getName()+" has play "+(++count)+" time");
			if(count==50){
				break;
			}
			if(count%10==0){
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		show("End of play");
	}
	public static void show(Object obj){
		System.out.println(obj);
	}
	
	

}
