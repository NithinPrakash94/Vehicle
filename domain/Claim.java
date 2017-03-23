package domain;

import java.util.Date;

public class Claim {

	 public Claim(String claim_id, String polcy_id, int weightage,
			 String accident_type, float claim_amnt) {
		super();
		this.claim_id = claim_id;
		this.polcy_id = polcy_id;
		this.weightage= weightage;
		this.accident_type = accident_type;
		this.claim_amnt = claim_amnt;
	}
	 
	 
	public Claim(String claim_id, String polcy_id, String theft_dt,
			String complaint_dt, String fir_no, String plc_stn_branch,
			float claim_amnt) {
		super();
		this.claim_id = claim_id;
		this.polcy_id = polcy_id;
		this.theft_dt = theft_dt;
		this.complaint_dt = complaint_dt;
		this.fir_no = fir_no;
		this.plc_stn_branch = plc_stn_branch;
		this.claim_amnt = claim_amnt;
	}


	public String claim_id;
	 public String polcy_id;
	 public int weightage;
	 public String theft_dt;
	 public String complaint_dt;
	 public String fir_no ;
	 public String plc_stn_branch ;
	 public String accident_type ;
	 public float claim_amnt;
	public String getClaim_id() {
		return claim_id;
	}
	public void setClaim_id(String claim_id) {
		this.claim_id = claim_id;
	}
	public String getPolcy_id() {
		return polcy_id;
	}
	public void setPolcy_id(String polcy_id) {
		this.polcy_id = polcy_id;
	}
	public int getWeightage() {
		return weightage;
	}
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	public String getTheft_dt() {
		return theft_dt;
	}
	public void setTheft_dt(String theft_dt) {
		this.theft_dt = theft_dt;
	}
	public String getComplaint_dt() {
		return complaint_dt;
	}
	public void setComplaint_dt(String complaint_dt) {
		this.complaint_dt = complaint_dt;
	}
	public String getFir_no() {
		return fir_no;
	}
	public void setFir_no(String fir_no) {
		this.fir_no = fir_no;
	}
	public String getPlc_stn_branch() {
		return plc_stn_branch;
	}
	public void setPlc_stn_branch(String plc_stn_branch) {
		this.plc_stn_branch = plc_stn_branch;
	}
	public String getAccident_type() {
		return accident_type;
	}
	public void setAccident_type(String accident_type) {
		this.accident_type = accident_type;
	}
	public float getClaim_amnt() {
		return claim_amnt;
	}
	public void setClaim_amnt(float claim_amnt) {
		this.claim_amnt = claim_amnt;
	}
	 
	 
}
