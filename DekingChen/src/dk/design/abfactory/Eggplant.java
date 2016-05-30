package dk.design.abfactory;

import dk.main.Show;

public class Eggplant extends Show implements Vegetable {

	@Override
	public void getName() {
		// TODO Auto-generated method stub
		show("This vegetable is banana.");
	}

	@Override
	public void getPrice() {
		// TODO Auto-generated method stub
		show("The price is 8 RMB.");
	}

}
