package dk.design.factory;

import java.util.Map;

/**
 * @author Administrator
 * 发型的工厂方法
 */
public class HairFactory {
	public static HairInterface getHair(String className) throws IllegalAccessException, ClassNotFoundException{
		
		try {
			HairInterface hair = (HairInterface) Class.forName(className).newInstance();
			return hair;
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static HairInterface  getHairByClassKey(String key) throws IllegalAccessException, ClassNotFoundException{
		try {
			Map<String,String> map = new PropertiesReader().getProperties();
			HairInterface hair = (HairInterface) Class.forName(map.get(key)).newInstance();
			return hair;
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}
}
