package dk.design.abfactory;

public class Factory02 implements Factory {

	@Override
	public Fruit getFruit() {
		// TODO Auto-generated method stub
		return new Banana();
	}

	@Override
	public Vegetable getVegetable() {
		// TODO Auto-generated method stub
		return new Eggplant();
	}

	@Override
	public Poultry getPoultry() {
		// TODO Auto-generated method stub
		return new Fish();
	}

}
