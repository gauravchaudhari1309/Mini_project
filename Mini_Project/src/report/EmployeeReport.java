package report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBconnect;

public class EmployeeReport {

	public String maxApparisal() {

		try (Connection con = DBconnect.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(
						"select ename,count(a.eid)as  count from employee as A inner join apparisal as B on a.eid=b.eid group by a.eid order by count desc limit 1")) {

			ResultSet status = preparedStatement.executeQuery();

			if (status.next()) {
				String name = status.getString("ename");

				return name;

			} else
				return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public String noApparisal() {

		String name = "";
		try (Connection con = DBconnect.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(
						"select ename from employee as A left join  apparisal as B on a.eid=b.eid where isnull(b.eid)")) {

			ResultSet status = preparedStatement.executeQuery();

			if (status.next()) {
				name = status.getString("ename") + "," + name;

			} else
				return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return name;

	}

}
