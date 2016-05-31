package dk.design.chain.handler;

public class CEO extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.6){
			System.out.format("%s批准了折扣：%.2f%n",this.getClass().getName(),discount);
		}else{
			System.out.println("CEO"+this.getClass().getName()+"拒绝了折扣要求");
		}

	}

}
