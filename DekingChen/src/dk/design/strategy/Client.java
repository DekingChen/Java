/**
 * 
 */
package dk.design.strategy;

import dk.design.strategy.lib.AdvancedMemberStrategy;
import dk.design.strategy.lib.IntermediateMemberStrategy;
import dk.design.strategy.lib.PrimaryMemberStrategy;

/**
 * @author Administrator
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MemberStrategy menber = new AdvancedMemberStrategy();
					   menber = new IntermediateMemberStrategy();
					   menber = new PrimaryMemberStrategy();
		
		BookPrice book = new BookPrice(menber);
		double price = book.quote(300);
		System.out.println("You are dvancedMember ,so you can get 20% discount! Your Price :"+price);
		
		RedHeadDuck red = new RedHeadDuck();
		red.display();
		red.quack();
		red.fly();
		
		System.out.println("=========================================");
		
		YellowDuck yellow = new YellowDuck();
		yellow.display();
		yellow.quack();
		yellow.fly();
		
		System.out.println("=========================================");
		
		SkyDuck sky = new SkyDuck();
		sky.display();
		sky.quack();
		sky.fly();
	}

}
