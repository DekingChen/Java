package dk.design.adapter;

public class TwoPlugAdapter implements ThreePluIf {

	private GBTwoPlug plug;
	
	public TwoPlugAdapter(GBTwoPlug plug) {
		super();
		this.plug = plug;
	}

	@Override
	public void powerWithThree() {
		System.out.println("ͨ��ת����");
		plug.powerWithTwo();
	}
	
	

}
