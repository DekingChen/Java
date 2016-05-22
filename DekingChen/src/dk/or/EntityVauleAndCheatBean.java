package dk.or;


/**
 * feature selector
 * 用于保存证据实体的域值及作弊标签
 * feng
 * 2016年2月25日
 **/
public class EntityVauleAndCheatBean implements Comparable<EntityVauleAndCheatBean>{
	private String name;
	private double thresholdValue;
	private boolean isCheat;
	public EntityVauleAndCheatBean(String name, double thresholdValue,
			boolean isCheat) {
		super();
		this.name = name;
		this.thresholdValue = thresholdValue;
		this.isCheat = isCheat;
	}
	public String getName() {
		return name;
	}
	public double getThresholdValue() {
		return thresholdValue;
	}
	public boolean isCheat() {
		return isCheat;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setThresholdValue(double thresholdValue) {
		this.thresholdValue = thresholdValue;
	}
	public void setCheat(boolean isCheat) {
		this.isCheat = isCheat;
	}
	@Override
	public String toString() {
		return "EntityVauleAndCheatBean [name=" + name + ", thresholdValue="
				+ thresholdValue + ", isCheat=" + isCheat + "]";
	}
	public int compareTo(EntityVauleAndCheatBean o) {
		if (this.thresholdValue==o.thresholdValue) {
			return 0;
		}else if (this.thresholdValue>o.thresholdValue) {
			return 1;
		}
		return -1;
	}

}

