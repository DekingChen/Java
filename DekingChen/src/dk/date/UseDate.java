/**
 * 
 */
package dk.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Administrator
 *
 */
public class UseDate {

	public Timer timer;
	
	public UseDate(){
		this.timer = new Timer();
	}
	
	public static void main(String[] args) {
		Date da=new Date();  //����ʱ�����
        System.out.println(da); //��ʾʱ�������
        long msec=da.getTime();
        System.out.println("��1970��1��1��0ʱ�����ڹ��У�" + msec + "����");
        //��ʽ������
        Date da1=new Date();
        System.out.println(da1);
        SimpleDateFormat ma1=new SimpleDateFormat("yyyy �� MM �� dd �� E ����ʱ��");
        System.out.println(ma1.format(da1));
        SimpleDateFormat ma2=new SimpleDateFormat("����ʱ�䣺yyyy �� MM �� dd �� HH ʱ mm �� ss ��");
        System.out.println(ma2.format(-1000));
		UseDate task = new UseDate();
		task.TaskOne(getTime());
	}
	
	public static Date getTime(){
		Calendar calendar = Calendar.getInstance();
		/*calendar.set(Calendar.YEAR, 2016);
		calendar.set(Calendar.MONTH, 6);
		calendar.set(Calendar.DAY_OF_YEAR, 16);
		calendar.set(Calendar.HOUR_OF_DAY, 21);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.SECOND, 00);*/
		calendar.set(2016, 05, 16, 21, 52, 00);
		Date time = calendar.getTime();
		System.out.println(time);
		return time;
		//return time;
		//SimpleDateFormat ma1= new SimpleDateFormat("����ʱ�䣺yyyy �� MM �� dd �� HH ʱ mm �� ss ��");
        //System.out.println(ma1.format(time));
		
	}
	
	public void TaskOne(Date date){
		timer.schedule(new TimerTask(){
			public void run(){
				Date da1=new Date();
		        System.out.println(da1);
		        SimpleDateFormat ma1=new SimpleDateFormat("yyyy �� MM �� dd �� E ����ʱ��");
		        System.out.println(ma1.format(da1));
				System.out.println("Hello,world!!!");
			}			
			}, date);
	}
	
	
	
}
