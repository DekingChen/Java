package dk.design.adapter;

public class NoteBook {
	private ThreePluIf plug;
	
	public NoteBook(ThreePluIf plug){
		this.plug = plug;
	}
	
	public ThreePluIf getPlug() {
		return plug;
	}

	public void setPlug(ThreePluIf plug) {
		this.plug = plug;
	}
	
	public void charge(){
		plug.powerWithThree();
	}

	public static void main(String arg[]){
		GBTwoPlug two = new GBTwoPlug();
		ThreePluIf plug = new TwoPlugAdapter(two);		
		NoteBook notebook = new NoteBook(plug);
		notebook.charge();
		
		plug = new TwoPlugAdapterExtends();
		notebook = new NoteBook(plug);
		notebook.charge();
	}
}
