package dk.design.adapter;

public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePluIf {

	@Override
	public void powerWithThree() {
		System.out.println("½èÖú¼Ì³ĞÊÊÅäÆ÷£º");
		this.powerWithTwo();

	}

}
