package dk.design.chain.handler;

public class Lead extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.15){
			System.out.format("%sÅú×¼ÁËÕÛ¿Û£º%.2f%n",this.getClass().getName(),discount);
		}else{
			successor.processDiscount(discount);
		}

	}

}
