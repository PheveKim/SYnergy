package synergy.model.dto;

import org.springframework.stereotype.Component;

public class OneRM {

	private String benchpress_weight;
	private String benchpress_rep;
	private String deadlift_weight;
	private String deadlift_rep;
	private String squat_weight;
	private String squat_rep;
	public OneRM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OneRM(String benchpress_weight, String benchpress_rep, String deadlift_weight, String deadlift_rep,
			String squat_weight, String squat_rep) {
		super();
		this.benchpress_weight = benchpress_weight;
		this.benchpress_rep = benchpress_rep;
		this.deadlift_weight = deadlift_weight;
		this.deadlift_rep = deadlift_rep;
		this.squat_weight = squat_weight;
		this.squat_rep = squat_rep;
	}
	public String getBenchpress_weight() {
		return benchpress_weight;
	}
	public void setBenchpress_weight(String benchpress_weight) {
		this.benchpress_weight = benchpress_weight;
	}
	public String getBenchpress_rep() {
		return benchpress_rep;
	}
	public void setBenchpress_rep(String benchpress_rep) {
		this.benchpress_rep = benchpress_rep;
	}
	public String getDeadlift_weight() {
		return deadlift_weight;
	}
	public void setDeadlift_weight(String deadlift_weight) {
		this.deadlift_weight = deadlift_weight;
	}
	public String getDeadlift_rep() {
		return deadlift_rep;
	}
	public void setDeadlift_rep(String deadlift_rep) {
		this.deadlift_rep = deadlift_rep;
	}
	public String getSquat_weight() {
		return squat_weight;
	}
	public void setSquat_weight(String squat_weight) {
		this.squat_weight = squat_weight;
	}
	public String getSquat_rep() {
		return squat_rep;
	}
	public void setSquat_rep(String squat_rep) {
		this.squat_rep = squat_rep;
	}
	@Override
	public String toString() {
		return "OneRM [benchpress_weight=" + benchpress_weight + ", benchpress_rep=" + benchpress_rep
				+ ", deadlift_weight=" + deadlift_weight + ", deadlift_rep=" + deadlift_rep + ", squat_weight="
				+ squat_weight + ", squat_rep=" + squat_rep + "]";
	}
	
	

}
