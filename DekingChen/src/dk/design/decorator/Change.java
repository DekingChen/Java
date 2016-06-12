package dk.design.decorator;

public class Change implements TheGreatestSage {
	
	private TheGreatestSage sage;
    
    public Change(TheGreatestSage sage){
        this.sage = sage;
    }
    protected void beforeChange(){
		System.out.println("Before Change,I am "+sage.getClass());
	}
	
	protected void afterChange(){
		System.out.println("After Change, I am " +getClass());
	}	
    @Override
    public void move() {
        // ДњТы
        sage.move();
    }

}
