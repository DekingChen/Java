/**
 * 
 */
package dk.timetask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 *
 */
public class ScheduledExecutor {

	private ScheduledExecutorService time_task;
	private long start;
	
	public ScheduledExecutor(){
		this.time_task = Executors.newScheduledThreadPool(30);
		this.start = System.currentTimeMillis();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledExecutor task = new ScheduledExecutor();
		task.TaskOne();
		task.TaskTwo();
		task.TaskThree();
	}
	
  public void TaskOne(){
		time_task.schedule(new Runnable(){
			public void run(){
				System.out.println("TaskOne invoked ,the time:" + (System.currentTimeMillis() - start));
				try {
				Thread.sleep(4000); //线程休眠3000
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		}, 1000, TimeUnit.MILLISECONDS);
	}
	
  public void TaskTwo(){
	   time_task.schedule(new Runnable(){
		   public void run(){
			   System.out.println("TaskTwo invoked ,the time:" + (System.currentTimeMillis() - start));
		   }
	   }, 2000, TimeUnit.MILLISECONDS);
   }
   
  public void TaskThree(){
	time_task.scheduleAtFixedRate(new Runnable() {
		int len  = 0;
		public void run() {
			if(len<5){
				System.out.println("TaskThree invoked ,the time:" + (System.currentTimeMillis() - start)+" 第"+len+"次");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				len++;
			}else{
				return;
			}
		}
		},2000,1000,TimeUnit.MILLISECONDS);
   }

}
