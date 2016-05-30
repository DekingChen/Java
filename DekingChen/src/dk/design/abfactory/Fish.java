package dk.design.abfactory;

import dk.main.Show;

public class Fish extends Show implements Poultry {

	@Override
	public void getName() {
		// TODO Auto-generated method stub
		show("This poultry is fish.");
	}

	@Override
	public void getPrice() {
		// TODO Auto-generated method stub
		show("The price is 100 RMB.");
	}

}
