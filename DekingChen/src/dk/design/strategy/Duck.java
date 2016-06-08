package dk.design.strategy;

public abstract class Duck {
	public void quack(){
		System.out.println("限限限。。。。。");
	}
	public abstract void display();
	
	private FlyingStrategy flyingStrategy;

	public FlyingStrategy getFlyingStrategy() {
		return flyingStrategy;
	}
	public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
		this.flyingStrategy = flyingStrategy;
	}
	public void fly(){
		flyingStrategy.performFly();
	}	
}
