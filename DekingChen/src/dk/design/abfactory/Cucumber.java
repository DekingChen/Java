package dk.design.abfactory;

import dk.main.Show;

public class Cucumber extends Show implements Vegetable {

	@Override
	public void getName() {
		show("This vegetable is apple");

	}

	@Override
	public void getPrice() {
		show("The price is 5 RMB.");
	}

}
