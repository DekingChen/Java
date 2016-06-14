package dk.socketApi;

import java.io.Serializable;

public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String contents;
	
	public Admin(String username,String contents) {
		super();
		this.username = username;
		this.contents = contents;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void say(){
		System.out.println(this.getUsername()+" say :"+contents);
	}
	
}
