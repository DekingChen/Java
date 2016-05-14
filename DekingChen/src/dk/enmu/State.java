/**
 * 
 */
package dk.enmu;

/**
 * @author Administrator
 *
 */
public enum State {
	Normal("����̬", 1), Update("�Ѹ���", 2), Deleted("��ɾ��", 3), Fired("������", 4);
	// ��Ա����
	private String name;
	private int index;

	// ���췽����ע�⣺���췽������Ϊpublic����Ϊenum�������Ա�ʵ����
	private State(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// ��ͨ����
	public static String getName(int index) {
		for (State c : State.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}

	// get set ����
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void showMsg() {
		System.out.println("I am Enum!");
	}
}
