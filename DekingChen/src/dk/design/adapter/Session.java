package dk.design.adapter;

public class Session {
	private API api;

	public Session(API api) {
		super();
		this.api = api;
	}
	
	public void request(){
		this.api.request();
	}
	
	public static void main(String args[]){
		Get get = new Get();
		API api = new GetAdapter(get);
		Session session = new Session(api);
		session.request();
		
		api = new GetApaterExtends();
		session = new Session(api);
		session.request();
	}
}
