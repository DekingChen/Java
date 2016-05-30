/**
 * 
 */
package dk.design;

import dk.design.factory.Boy;
import dk.design.factory.Girl;
import dk.design.factory.HairFactory;
import dk.design.factory.HairInterface;
import dk.design.factory.MCFactory;
import dk.design.factory.PersonFactory;
import dk.design.singleton.Singleton01;
import dk.main.Show;

/**
 * @author Administrator
 *
 */
public class Index extends Show{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testSingle();
		testFactory();
	}
	
	public static void  testSingle(){
		Singleton01 s1 = Singleton01.getInstance();
		Singleton01.test=10;
		Singleton01 s2 = Singleton01.getInstance();
		if(s1==s2){
			show(s1.getClass().getName()+"��"+s2.getClass().getName()+"��ͬһ��ʵ��");
		}else{
			show("s1��s2����ͬһ��ʵ��");
		}
	}
	
	public static void testFactory(){
		HairInterface left = HairFactory.getHairByClassKey("left");
		left.draw();
		PersonFactory factory = new MCFactory();
		Boy boy = factory.getBoy();
		boy.drowBoy();
		Girl girl = factory.getGirl();
		girl.drawGirl();
	}
	
	public static void testChain(){
		
	}
}
