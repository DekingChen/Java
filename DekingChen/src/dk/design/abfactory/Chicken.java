package dk.design.abfactory;

import dk.main.Show;

public class Chicken extends Show implements Poultry {

	@Override
	public void getName() {
		show("This poultry is apple");

	}

	@Override
	public void getPrice() {
		show("The price is 100 RMB.");
	}

}
