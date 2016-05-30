package dk.design.singleton;

/**
 * @author Administrator
 * 但getInstance会被外部线程比较频繁的调用，同步比非同步的性能消耗要昂贵很多，
 * 因此这样的做法会存在很大的额外性能消耗
 */
public class Singleton03 {
		//1.将构造方法私有化
		private Singleton03(){}
		//2.创建类的唯一实例
		private static Singleton03 singleton02;
		//3.开发获取单例的接口
		//4.为了多线程不出错，加入了同步标志  
		public static synchronized  Singleton03 getInstance(){
			if(singleton02==null){
				singleton02 = new Singleton03();
			}
			return singleton02;
		}
}
