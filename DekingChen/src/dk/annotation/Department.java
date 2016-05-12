package dk.annotation;
@Table(table="Department")
public class Department {
	@Column(column="id")
	private String id;
	@Column(column="name")
	private String name;
	@Column(column="sum")
	private int sum;
	@Column(column="leader")
	private String leader;
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
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	
}
