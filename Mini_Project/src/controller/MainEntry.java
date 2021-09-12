package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import config.DBconnect;
import dao.ApparisalDao;
import dao.ApparisalDaoImpl;
import dao.EmpDaoImpl;
import dao.JobRoleDao;
import dao.JobRoleDaoImpl;
import model.Employee;
import model.JobRole;
import report.EmployeeReport;
import service.EmpInterfaceService;
import service.EmpService;
import service.RoleInterfaceService;
import service.RoleService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Application has maintained information about journey of employee in the company  

public class MainEntry {

	private static RoleInterfaceService roleInterfaceService = new RoleService();

	static ArrayList<String> validRoles(String jrname) {
		return roleInterfaceService.getValidRoles(jrname);

	}

	public static void showEmployeeList() {

		EmpDaoImpl empdoaImplObj = new EmpDaoImpl();
		List<Employee> employeeList = empdoaImplObj.getAllEmp();
		System.out.println("Employee details: ");
		Iterator<Employee> iteratorObj = employeeList.iterator();
		System.out.println("EmployeeId" + " " + "Employeename" + " " + "Address" + " " + "Mobile" + "          "
				+ "Salary" + " " + "Qualification" + "   " + "DepartmentID" + "  " + "JobRoleId");
		while (iteratorObj.hasNext()) {

			Employee employee = iteratorObj.next();

			System.out.println(employee.getEid() + " \t\t" + employee.getEname() + " \t" + employee.getAddress() + " \t"
					+ employee.getMobile() + " \t" + employee.getSalary() + "  \t" + employee.getQualification()
					+ " \t\t" + employee.getDid() + "  \t\t" + employee.getJid());
		}
	}

	public static void showJobList() {

		JobRoleDao jobRoleDoaObj = new JobRoleDaoImpl();
		List<JobRole> jobRoleList = jobRoleDoaObj.getAlljob();
		System.out.println("Job Roles Details: ");
		Iterator<JobRole> iteratorObj = jobRoleList.iterator();
		System.out.println("Job_Id" + " " + "JobRole_Name");
		while (iteratorObj.hasNext()) {

			JobRole jobRole = iteratorObj.next();

			System.out.println(jobRole.getJid() + " \t" + jobRole.getJr_name());
		}
	}

	public boolean displayAllRoles() {

		ResultSet resultset = roleInterfaceService.getRoleSet();
		try {
			while (resultset.next()) {
				System.out
						.println("Role ID->" + resultset.getInt(1) + " | Role Name ->" + resultset.getString("Intern"));
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static int getJobid(int eid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DBconnect.getConnection();
		int jid = 0;
		try {
			preparedStatement = connection.prepareStatement("select jid from employee where eid=" + eid + " ;");
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				jid = rs.getInt("jid");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return jid;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			System.out.println("\n1-> Add Apparisal information");
			System.out.println("2-> Add new JobRole");
			System.out.println("3-> Modify JobRole");
			System.out.println("4-> Delete JobRole");
			System.out.println("5-> Generate Reports");
			System.out.println("6-> Exit\n\nEnter your Choice");
			try {

				int taskchoice = sc.nextInt();

				switch (taskchoice) {

				case 1:
					// • Add information about appraisal for any employee
					showEmployeeList();
					System.out.println("\nEnter employee id");

					int eid = sc.nextInt();
					System.out.println("\nYou want to update role ?(y/n)");
					char ch = sc.next().charAt(0);
					if (ch == 'y' | ch == 'Y') {

						int jid = getJobid(eid);

						System.out.println("\nEnter new Role Id: ");
						int newRoleid = sc.nextInt();
						if (newRoleid > jid + 2) {
							System.out.println("Cant  give more than 2 level promotion :(");
						} else if (newRoleid < jid) {
							System.out.println("Cant Demote Employee :(");
						} else if (newRoleid == jid) {
							System.out.println("Cant give same designation twice :(");
						} else {

							EmpInterfaceService empInterfaceService = new EmpService();
							if (empInterfaceService.updateERole(eid, newRoleid)) {
								System.out.println("Role Updated");
								System.out.println("Apparisal Done :)");
							}
						}
					} else if (ch == 'N' | ch == 'n') {
						ApparisalDao apprisalDaoObj = new ApparisalDaoImpl();
						if (apprisalDaoObj.addEmployeeAppraisal(eid, 0)) {
							System.out.println("Apparisal Done :)");

						}
					}
					break;

				case 2:
					// • Add new roles
					showJobList();
					System.out.println("\nEnter new jobrole name");
					String role = sc.next();
					JobRole jobRoleObj = new JobRole();
					jobRoleObj.setJr_name(role);
					JobRoleDao jobRoleDaoObj = new JobRoleDaoImpl();
					if (jobRoleDaoObj.addNewRole(jobRoleObj)) {
						System.out.println("Role Added !");

					} else {
						System.out.println("OOps Invalid Input :(");
					}
					break;

				case 3:
					// • Modify roles
					showJobList();
					System.out.println("\nEnter id from above list to modify ");
					int jid = sc.nextInt();
					System.out.println("Enter new Job name");
					String jobname = sc.next();

					JobRoleDao jobRoleDaoObj1 = new JobRoleDaoImpl();
					if (jobRoleDaoObj1.modifyRole(jid, jobname)) {

						System.out.println("Role modified :)");

					} else {
						System.out.println("Role Cant Modified :(");
					}
					break;

				case 4:
					// • Delete roles
					showJobList();

					System.out.println("\nEnter id from above list to delete");
					int jid1 = sc.nextInt();
					JobRoleDao jobRoleDaoObj2 = new JobRoleDaoImpl();
					if (jobRoleDaoObj2.deleteRole(jid1)) {

						System.out.println("Role Deleted :)");

					} else {
						System.out.println("Role Cant Delete :(");
					}
					break;

				case 5:
					// Reports

					// • Employee with maximum appraisals
					EmployeeReport report = new EmployeeReport();
					String name = report.maxApparisal();
					System.out.println(name + " has Max Apparisals");

					// • Employees who did not have appraisal
					String name1 = report.noApparisal();
					System.out.println(name1 + " got no Apparisals  ");
					break;
				
				case 6:
					flag = true;
					break;
				
				default:
					System.out.println("Please Enter Valid Option :(");
					break;
				}

				

			} catch (Exception e) {
				System.out.println(e);
			}
		} while (!flag);
		sc.close();
	}

}
