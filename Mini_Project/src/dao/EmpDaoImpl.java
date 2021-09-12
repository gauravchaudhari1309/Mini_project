package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBconnect;
import model.Employee;

public class EmpDaoImpl implements EmpDao {

	public int returnRoleid(int eid) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rset = null;

		try {
			connection = DBconnect.getConnection();
			preparedStatement = connection.prepareStatement("select jid from employee where eid=" + eid + " ;");
			rset = preparedStatement.executeQuery();
			rset.next();
			int croleid = rset.getInt(1);
			return croleid;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public boolean add(Employee e) {

		try (Connection con = DBconnect.getConnection();
				PreparedStatement preparedStatementt = con
						.prepareStatement("insert into employee values (?,?,?,?,?,?,?,?)")) {
			preparedStatementt.setInt(1, e.getEid());
			preparedStatementt.setString(2, e.getEname());
			preparedStatementt.setString(3, e.getAddress());
			preparedStatementt.setLong(4, e.getMobile());
			preparedStatementt.setString(5, e.getQualification());
			preparedStatementt.setInt(6, e.getSalary());
			preparedStatementt.setInt(7, e.getDid());
			preparedStatementt.setInt(8, e.getJid());
			int c = preparedStatementt.executeUpdate();
			if (c > 0)
				System.out.println("Record Inserted");
			else
				System.out.println("Unsuccessful");
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		return false;
	}

	public List<Employee> getAllEmp() {

		List<Employee> employeeList = new ArrayList<Employee>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBconnect.getConnection();
			preparedStatement = connection.prepareStatement("select * from Employee");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee empolyeeObj = new Employee();
				empolyeeObj.setEid(resultSet.getInt(1));
				empolyeeObj.setEname(resultSet.getString(2));
				empolyeeObj.setAddress(resultSet.getString(3));
				empolyeeObj.setMobile(resultSet.getLong(4));
				empolyeeObj.setQualification(resultSet.getString(5));
				empolyeeObj.setSalary(resultSet.getInt(6));
				empolyeeObj.setDid(resultSet.getInt(7));
				empolyeeObj.setJid(resultSet.getInt(8));
				employeeList.add(empolyeeObj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return employeeList;
	}

	public boolean updateERole(int eid, int newRoleid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			ApparisalDaoImpl apprisalDaoObj = new ApparisalDaoImpl();
			connection = DBconnect.getConnection();
			preparedStatement = connection
					.prepareStatement("update employee set jid=" + newRoleid + " where eid =" + eid + " ;");

			if (apprisalDaoObj.addEmployeeAppraisal(eid, newRoleid)) {
				int i = preparedStatement.executeUpdate();
				if (i > 0) {
					return true;
				} else
					return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

}