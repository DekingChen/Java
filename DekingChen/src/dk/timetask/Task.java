/**
 * 
 */
package dk.timetask;

import java.util.TimerTask;

/**
 * @author Administrator
 *
 */
public class Task extends TimerTask{


	public static int count = 0;
	
	@Override
	public void run() {
		   if(count<10){
		    	System.out.println("第"+count+"个DekingChen");
		    	count++;
		    }else{
		    	this.cancel();
		    }
		//count++;
    	//System.out.println("第"+count+"个DekingChen");

	}

}
