package dk.design.abfactory;

import dk.main.Show;

public class Banana extends Show implements Fruit {

	@Override
	public void getName() {
		// TODO Auto-generated method stub
		show("This fruit is Banana");
	}

	@Override
	public void getPrice() {
		// TODO Auto-generated method stub
		show("The price is 7.5 RMB.");
	}

}
