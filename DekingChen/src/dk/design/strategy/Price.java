package dk.design.strategy;

public abstract class Price {
	//����һ������Ĳ��Զ���
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
