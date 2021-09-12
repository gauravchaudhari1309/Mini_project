package model;

import java.sql.Date;

public class Apparisal {

	private int eid;
	private Date apparisal_date;
	private String cur_role;
	private String new_role;
	private int apid;

	Apparisal() {

	}

	public Apparisal(int eid, Date ap_date, String cur_role, String new_role, int apid) {
		super();
		this.eid = eid;
		this.apparisal_date = ap_date;
		this.cur_role = cur_role;
		this.new_role = new_role;
		this.apid = apid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Date getApparisal_date() {
		return apparisal_date;
	}

	public void setApparisal_date(Date apparisal_date) {
		this.apparisal_date = apparisal_date;
	}

	public String getCur_role() {
		return cur_role;
	}

	public void setCur_role(String cur_role) {
		this.cur_role = cur_role;
	}

	public String getNew_role() {
		return new_role;
	}

	public void setNew_role(String new_role) {
		this.new_role = new_role;
	}

	public int getApid() {
		return apid;
	}

	public void setApid(int apid) {
		this.apid = apid;
	}

	
	public String toString() {
		return "Apparisal [eid=" + eid + ", apparisal_date=" + apparisal_date + ", cur_role=" + cur_role + ", new_role="
				+ new_role + ", apid=" + apid + "]";
	}

}
