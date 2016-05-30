
package dk.design.singleton;

/**
 * @author Administrator
 * 单例模式之懒汉模式：:指全局的单例实例在第一次被使用时构建，延迟初始化。
 * 类加载速度慢，运行速度快--线程不安全
 */
public class Singleton02 {
	//1.将构造方法私有化
	private Singleton02(){}
	//2.创建类的唯一实例
	private static Singleton02 singleton02;
	//3.开发获取单例的接口
	public static Singleton02 getInstance(){
		if(singleton02==null){
			singleton02 = new Singleton02();
		}
		return singleton02;
	}
}
