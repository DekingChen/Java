package dk.design.factory;

import dk.main.Show;

public class RightHair extends Show implements HairInterface {

	@Override
	public void draw() {
		show("This is right hair type£¡");
	}

}
