package dk.design.abfactory;

import dk.main.Show;

public class Factory01 extends Show implements Factory {

	@Override
	public Fruit getFruit() {
		// TODO Auto-generated method stub
		return new Apple();
	}

	@Override
	public Vegetable getVegetable() {
		// TODO Auto-generated method stub
		return new Cucumber();
	}

	@Override
	public Poultry getPoultry() {
		// TODO Auto-generated method stub
		return new Chicken();
	}

}
