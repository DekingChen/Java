/**
 * 
 */
package dk.enmu;

import dk.annotation.User;

/**
 * @author Administrator
 *
 */
public enum UserEnum {
	Person(new User(),"user");
	private User user;
	private String name;
	private UserEnum(User user ,String name){
		this.user = user;
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
