package footprint.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.EmployeeDao;
import footprint.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao; 
	
	public boolean addEmployee(Employee employee) {
		employee.setPassword(BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt(12)));
		employee.setRole("STAFF");
		return employeeDao.addEmployee(employee);
	}
	
	public Employee getEmployeeByEmail(String email) {
		return employeeDao.getEmployeeByEmail(email);
	}

	public boolean update(Employee employee) {
		return employeeDao.update(employee);
	}	
	
	public Employee getEmployeeWithId(String idEmployee) {
		return employeeDao.getEmployeeWithId(idEmployee); 
	}
	
	public List<Employee> getEmployeeWithRole(String role) {
		return employeeDao.getEmployeeWithRole(role);
	}
}
