package dk.design.singleton;
/**
 * @author Administrator
 * 单例模式之恶汉模式：指全局的单例实例在类装载时构建， 急切初始化。
 * 类加载速度快，运行速度较慢--线程安全
 * 
 */
public class Singleton01 {
	//1.将构造方法私有化
	private Singleton01(){}
	//2.创建类的唯一实例
	public static int test = 100;
	private static Singleton01 singleton01 = new Singleton01();
	//3.开发获取单例的接口
	public static Singleton01 getInstance(){
		return singleton01;
	}
}
