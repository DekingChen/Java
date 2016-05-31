package dk.design.chain;

import java.util.Random;

import dk.design.chain.handler.PriceHanderFactory;
import dk.design.chain.handler.PriceHandler;

public class Customer {
	private  PriceHandler priceHandler;

	public PriceHandler getPriceHandler() {
		return priceHandler;
	}

	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}
	
	public  void requestDiscount(float discount){
		priceHandler.processDiscount(discount);
	}
	
	public static void main(String[] args){
		Customer c = new Customer();
		c.setPriceHandler(PriceHanderFactory.createPriceHandler());
		Random rand = new Random();
		for(int i=0;i<10;i++){
			System.out.println(i+":");
			c.requestDiscount(rand.nextFloat());
		}
	}
}
