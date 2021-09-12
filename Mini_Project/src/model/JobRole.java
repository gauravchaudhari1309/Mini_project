package model;

public class JobRole {

	private int jid;
	private String jr_name;

	public JobRole() {

	}

	public JobRole(int jid, String jr_name) {
		super();
		this.jid = jid;
		this.jr_name = jr_name;
	}

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public String getJr_name() {
		return jr_name;
	}

	public void setJr_name(String jr_name) {
		this.jr_name = jr_name;
	}

	@Override
	public String toString() {
		return "JobRole [jid=" + jid + ", jr_name=" + jr_name + "]";
	}

}
