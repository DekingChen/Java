package dk.design.strategy;


public class BookPrice extends Price {
	
	public BookPrice(MemberStrategy strategy){
		super();
		this.strategy = strategy;
		super.setStrategy(strategy);
	}
}
