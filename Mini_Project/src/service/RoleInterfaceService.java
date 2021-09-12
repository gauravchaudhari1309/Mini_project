package service;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface RoleInterfaceService {

	ArrayList<String> getValidRoles(String jrname);

	ResultSet getRoleSet();

	ArrayList<String> validJobRole(String jrname);

	ArrayList<String> validJobRoles(String jrname);

}
