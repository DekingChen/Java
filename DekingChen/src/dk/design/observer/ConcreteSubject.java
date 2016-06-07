package dk.design.observer;

public class ConcreteSubject extends Subject {
	private String subjectState;

	public ConcreteSubject(String subjectState) {
		this.subjectState = subjectState;
		this.notifyObservers();
	}

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
		this.notifyObservers();
	}
	
}
