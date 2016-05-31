package dk.design.chain.handler;

public class CEO extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.6){
			System.out.format("%s��׼���ۿۣ�%.2f%n",this.getClass().getName(),discount);
		}else{
			System.out.println("CEO"+this.getClass().getName()+"�ܾ����ۿ�Ҫ��");
		}

	}

}
