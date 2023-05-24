package synergy.model.dto;

import org.springframework.stereotype.Component;

public class Routine {

	private String person_weight;
	private String person_height;
	private String B;
	private String D;
	private String S;
	public Routine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Routine(String person_weight, String person_height, String b, String d, String s) {
		super();
		this.person_weight = person_weight;
		this.person_height = person_height;
		B = b;
		D = d;
		S = s;
	}
	public String getPerson_weight() {
		return person_weight;
	}
	public void setPerson_weight(String person_weight) {
		this.person_weight = person_weight;
	}
	public String getPerson_height() {
		return person_height;
	}
	public void setPerson_height(String person_height) {
		this.person_height = person_height;
	}
	public String getB() {
		return B;
	}
	public void setB(String b) {
		B = b;
	}
	public String getD() {
		return D;
	}
	public void setD(String d) {
		D = d;
	}
	public String getS() {
		return S;
	}
	public void setS(String s) {
		S = s;
	}
	@Override
	public String toString() {
		return "Routine [person_weight=" + person_weight + ", person_height=" + person_height + ", B=" + B + ", D=" + D
				+ ", S=" + S + "]";
	}
	
	

}
