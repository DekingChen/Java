package dk.design.singleton;

/**
 * @author Administrator
 * ��getInstance�ᱻ�ⲿ�̱߳Ƚ�Ƶ���ĵ��ã�ͬ���ȷ�ͬ������������Ҫ����ܶ࣬
 * �����������������ںܴ�Ķ�����������
 */
public class Singleton03 {
		//1.�����췽��˽�л�
		private Singleton03(){}
		//2.�������Ψһʵ��
		private static Singleton03 singleton02;
		//3.������ȡ�����Ľӿ�
		//4.Ϊ�˶��̲߳�����������ͬ����־  
		public static synchronized  Singleton03 getInstance(){
			if(singleton02==null){
				singleton02 = new Singleton03();
			}
			return singleton02;
		}
}
