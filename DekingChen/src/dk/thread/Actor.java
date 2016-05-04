package dk.thread;

public class Actor extends Thread {
	
	public void run(){
		show(getName()+" is a actor!");
		int count = 0;
		boolean keep = true;
		while(keep){
			show(getName()+" has play "+(++count)+" time");
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
	
	public static void main(String args[]){
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		actor.start();
		Thread actress = new Thread(new Actress(),"Ms.Runnable");
		actress.start();
	}
		
}
