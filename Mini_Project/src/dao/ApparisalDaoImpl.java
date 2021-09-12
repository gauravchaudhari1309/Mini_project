package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.DBconnect;

public class ApparisalDaoImpl implements ApparisalDao {

	public boolean addEmployeeAppraisal(int eid, int newRoleid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			EmpDaoImpl empObj = new EmpDaoImpl();
			connection = DBconnect.getConnection();
			preparedStatement = connection.prepareStatement(
					"insert into apparisal(eid,apparisal_date,current_role,new_role ) values (?,curdate(),?,?) ;");
			int curRoleid = empObj.returnRoleid(eid);
			if (curRoleid > 0) {
				preparedStatement.setInt(1, eid);
				preparedStatement.setInt(2, curRoleid);
				preparedStatement.setInt(3, newRoleid);

			}
			preparedStatement.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
