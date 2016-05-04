package dk.thread;

public class Stage extends Thread {

	public  void run(){
		
		show("舞台剧即将开始");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		show("舞台银幕徐徐拉开。。。。");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		show("隋唐末年,天下大乱,民不聊生。。。。。");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		show("农民起义。。。。");
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军");
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		show("半路杀出个程咬金。。。。。");
		Thread mrCheng = new keyPersonThread();
		mrCheng.setName("程咬金");
		show("给我杀啊。。。。");
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mrCheng.start();
		try {
			mrCheng.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		show("天下太平！");
	}
	
	public static void main(String[] args) {
		new Stage().start();

	}
	public static void show(Object obj){
		System.out.println(obj);
	}

}
