package dk.design.design;

/**
 * @author Administrator
 * 抽象工厂方法
 */
public interface PersonFactory {
	public Boy  getBoy();
	public Girl getGirl();
}
