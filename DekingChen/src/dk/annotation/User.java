package dk.annotation;

@Table(table="User")
public class User {

	@Column(column="id")
	private String id;
	@Column(column="name")
	private String name;
	@Column(column="nickname")
	private String nickname;
	@Column(column="age")
	private int age;
	@Column(column="email")
	private String email;
	@Column(column="city")
	private String city;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
