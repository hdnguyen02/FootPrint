package footprint.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import footprint.entity.Employee;


@Repository
@Transactional
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> getEmployeeWithRole(String role) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Employee where role = :role";
		Query query = session.createQuery(hql);
		query.setParameter("role", role);
		@SuppressWarnings("unchecked")
		List<Employee> employee = query.list();
		return employee;
	}

	public boolean addEmployee(Employee employee) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	public Employee getEmployeeWithId(String idEmployee) {
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.get(Employee.class, idEmployee);
		session.close();
		return employee;
	}

	public boolean update(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}
	
	public Employee getEmployeeByEmail(String email) { 
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Employee where email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		try {
			return (Employee) query.list().get(0);
		}
		catch(Exception e) {
			return null;
		}
	}
}
