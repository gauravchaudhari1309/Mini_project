package model;

public class Employee {

	private int eid;
	private String ename;
	private int salary;
	private String address;
	private String qualification;
	private long mobile;
	private int did;
	private int jid;

	public Employee() {

	}

	public Employee(int eid, String ename, int salary, String address, String qualification, long mobile, int did,
			int jid) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.address = address;
		this.qualification = qualification;
		this.mobile = mobile;
		this.did = did;
		this.jid = jid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", address=" + address
				+ ", qualification=" + qualification + ", mobile=" + mobile + ", did=" + did + ", jid=" + jid + "]";
	}

}