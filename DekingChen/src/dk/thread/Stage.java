package dk.thread;

public class Stage extends Thread {

	public  void run(){
		
		show("��̨�缴����ʼ");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		show("��̨��Ļ����������������");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		show("����ĩ��,���´���,����������������");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		show("ũ�����塣������");
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"���");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"ũ�������");
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		show("��·ɱ������ҧ�𡣡�������");
		Thread mrCheng = new keyPersonThread();
		mrCheng.setName("��ҧ��");
		show("����ɱ����������");
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
		show("����̫ƽ��");
	}
	
	public static void main(String[] args) {
		new Stage().start();

	}
	public static void show(Object obj){
		System.out.println(obj);
	}

}
