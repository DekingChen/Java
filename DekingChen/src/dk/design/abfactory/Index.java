package dk.design.abfactory;

import dk.main.Show;

public class Index extends Show{

	public static void main(String[] args) {
		Factory factory = new Factory01();
		Fruit apple = factory.getFruit();
		apple.getName();
		apple.getPrice();
		factory = new Factory02();
		Fruit banana = factory.getFruit();
		banana.getName();
		banana.getPrice();
	}

}
