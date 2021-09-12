package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBconnect;
import model.JobRole;

public class JobRoleDaoImpl implements JobRoleDao {

	public boolean addNewRole(JobRole jobRoleObj) {

		int status = 0;
		try (Connection con = DBconnect.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement("insert into job_role(JRname) values(?)")) {

			preparedStatement.setString(1, jobRoleObj.getJr_name());
			status = preparedStatement.executeUpdate();
			if (status > 0) {
				return true;

			} else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<JobRole> getAlljob() {
		List<JobRole> jobRoleList = new ArrayList<JobRole>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBconnect.getConnection();
			preparedStatement = connection.prepareStatement("select * from job_role");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				JobRole jobRoleObj = new JobRole();
				jobRoleObj.setJid(resultSet.getInt(1));
				jobRoleObj.setJr_name(resultSet.getString(2));
				jobRoleList.add(jobRoleObj);
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

		return jobRoleList;
	}

	public boolean modifyRole(int jid, String jrname) {

		try (Connection con = DBconnect.getConnection();
				PreparedStatement preparedStatement = con
						.prepareStatement("update job_role set jrname=? where  jid=? ")) {

			preparedStatement.setString(1, jrname);
			preparedStatement.setInt(2, jid);
			int status = preparedStatement.executeUpdate();
			if (status > 0) {
				return true;

			} else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteRole(int jid) {

		try (Connection con = DBconnect.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement("Delete from job_role where jid=?")) {

			preparedStatement.setInt(1, jid);

			int status = preparedStatement.executeUpdate();
			if (status > 0) {
				return true;

			} else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
