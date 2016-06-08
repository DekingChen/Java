package dk.design.adapter;

public class GetAdapter implements API{

	private Get get;
	
	public GetAdapter(Get get) {
		super();
		this.get = get;
	}

	@Override
	public void request() {
		this.get.get();
	}
	
}

class GetApaterExtends extends Get implements API{

	@Override
	public void request() {
		this.get();
	}
	
}
