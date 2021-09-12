package service;

import java.util.List;

import dao.EmpDao;
import dao.EmpDaoImpl;
import model.Employee;

public class EmpService implements EmpInterfaceService {
	EmpDao empObj = new EmpDaoImpl();

	public void add(Employee e) {
	}

	public void delete(int eid) {
	}

	public List<Employee> getAllemp() {
		return null;
	}

	public void updateByName(int id) {
	}

	public boolean validateEid(int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	public Employee returnEmpData(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateERole(int eid, int newRoleid) {
		return empObj.updateERole(eid, newRoleid);

	}

}
