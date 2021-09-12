package service;

import model.Employee;

public interface EmpInterfaceService {

	boolean validateEid(int employeeId);

	Employee returnEmpData(int employeeId);

	public boolean updateERole(int eid, int newRoleid);

}
