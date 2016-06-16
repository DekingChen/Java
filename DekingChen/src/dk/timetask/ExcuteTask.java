/**
 * 
 */
package dk.timetask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Administrator
 *
 */
public class ExcuteTask {

	private Timer time_task;
	
	private long start;
		
	
	public ExcuteTask(){
		super();
		this.time_task = new Timer();
		this.start = System.currentTimeMillis();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ExcuteTask task  = new ExcuteTask();
		//task.TaskOne();
		//task.TaskTwo();
		//task.TaskThree();
		//task.TaskFour();
		task.TaskFive();
		task.TaskSix();
		System.out.println("Task is begin...");
		
		/*Timer timer = new Timer();
		System.out.println("Starting....:");
		Task task = new Task();
		timer.schedule(task, 1000,2000);
		
		Timer time = new Timer();
		time.schedule(new Task(), 1000,2000);*/
		//task.run();
	//	new Task().run();
		//System.out.println(task.count);

	}
	
	public Date getTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 11);
		calendar.set(Calendar.MINUTE, 39);
		calendar.set(Calendar.SECOND, 00);
		Date time = calendar.getTime();
		return time;
	}
	
   public void TaskOne(){
		time_task.schedule(new TimerTask(){
			public void run(){
				System.out.println("TaskOne invoked ,the time:" + (System.currentTimeMillis() - start));
				try {
				Thread.sleep(4000); //线程休眠3000
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		}, 1000);
	}
	
   public void TaskTwo(){
	   time_task.schedule(new TimerTask(){
		   public void run(){
			   System.out.println("TaskTwo invoked ,the time:" + (System.currentTimeMillis() - start));
		   }
	   }, 7000);
   }
   
   public void TaskThree(){
	   time_task.scheduleAtFixedRate(new TimerTask(){
		   public void run(){
			   System.out.println("TaskThree invoked ,the time:" + (System.currentTimeMillis() - start));
				try {
				Thread.sleep(4000); //线程休眠3000
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
		   }
	   }, 1000, 1000);
   }
   
   public void TaskFour(){
	   time_task.scheduleAtFixedRate(new TimerTask(){
		   public void run(){
			   System.out.println("TaskFour invoked ,the time:" + (System.currentTimeMillis() - start));
		   }
	   }, 3000, 1000);
   }
   
   public void TaskFive(){
	   
	   time_task.schedule(new TimerTask(){
		   int len  = 1;
		   public void run(){
			   if(len<=10){
				   System.out.println("TaskFive invoked ,the time:" + (System.currentTimeMillis() - start)+" 第"+len+"次");
				   len++;
			   }else{
				   System.out.println("TaskFive is over!");
				   this.cancel();
			   }
		   }
	   }, 0,1000);
   }
   
   public void TaskSix(){
	   time_task.schedule(new TimerTask(){
		   int len  = 1;
		   public void run(){
			   if(len<=5){
				   System.out.println("TaskSix invoked ,the time:" + (System.currentTimeMillis() - start)+" 第"+len+"次");
				   len++;
			   }else{
				   /*try {
					throw new RuntimeException();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				   System.out.println("TaskSix is over!");
				   this.cancel();
				   //throw new RuntimeException();
			   }
		   }
	   }, 0,1000);
   }

}
