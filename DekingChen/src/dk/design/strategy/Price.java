package dk.design.strategy;

public abstract class Price {
	//持有一个具体的策略对象
    protected MemberStrategy strategy;
    
    public double quote(double booksPrice){
        return this.strategy.calcPrice(booksPrice);
    }

	public MemberStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(MemberStrategy strategy) {
		this.strategy = strategy;
	}
    
    
}
