package dk.design.singleton;
/**
 * @author Administrator
 * ����ģʽ֮��ģʽ��ָȫ�ֵĵ���ʵ������װ��ʱ������ ���г�ʼ����
 * ������ٶȿ죬�����ٶȽ���--�̰߳�ȫ
 * 
 */
public class Singleton01 {
	//1.�����췽��˽�л�
	private Singleton01(){}
	//2.�������Ψһʵ��
	public static int test = 100;
	private static Singleton01 singleton01 = new Singleton01();
	//3.������ȡ�����Ľӿ�
	public static Singleton01 getInstance(){
		return singleton01;
	}
}
