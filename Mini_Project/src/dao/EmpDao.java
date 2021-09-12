package dao;

import java.util.List;
import model.Employee;

public interface EmpDao {

	public boolean add(Employee e);

	

	public List<Employee> getAllEmp();

	public boolean updateERole(int eid, int newRoleid);

	public int returnRoleid(int eid);
}
