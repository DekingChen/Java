package dk.design.adapter;

public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePluIf {

	@Override
	public void powerWithThree() {
		System.out.println("�����̳���������");
		this.powerWithTwo();

	}

}
