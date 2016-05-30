package dk.design.abfactory;

import dk.main.Show;

public class Apple extends Show implements Fruit {

	@Override
	public void getName() {
		show("This fruit is apple");

	}

	@Override
	public void getPrice() {
		show("The price is 10 RMB.");
	}

}
