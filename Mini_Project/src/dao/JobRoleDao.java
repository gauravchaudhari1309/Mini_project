package dao;

import java.util.List;

import model.JobRole;

public interface JobRoleDao {

	public List<JobRole> getAlljob();

	boolean addNewRole(JobRole jobRoleObj);

	public boolean modifyRole(int jid, String jrname);

	public boolean deleteRole(int jid);
}
