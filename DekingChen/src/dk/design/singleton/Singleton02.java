
package dk.design.singleton;

/**
 * @author Administrator
 * ����ģʽ֮����ģʽ��:ָȫ�ֵĵ���ʵ���ڵ�һ�α�ʹ��ʱ�������ӳٳ�ʼ����
 * ������ٶ����������ٶȿ�--�̲߳���ȫ
 */
public class Singleton02 {
	//1.�����췽��˽�л�
	private Singleton02(){}
	//2.�������Ψһʵ��
	private static Singleton02 singleton02;
	//3.������ȡ�����Ľӿ�
	public static Singleton02 getInstance(){
		if(singleton02==null){
			singleton02 = new Singleton02();
		}
		return singleton02;
	}
}
