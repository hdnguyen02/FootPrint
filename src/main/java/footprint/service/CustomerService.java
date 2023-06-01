package footprint.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import footprint.dao.CustomerDao;
import footprint.entity.Customer;


@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao; 
	
	public boolean insertCustomer(Customer customer) {
		customer.setPassword(BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt(12)));
		return customerDao.insert(customer);
	}
	

	public Customer getCustomerByEmail(String email) {
		return customerDao.getCustomerByEmail(email);
	}

	
	public boolean update(Customer customer) {
		return customerDao.update(customer);
	}	

	public boolean changePassword(Customer customer,String newPassword) {
		customer.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(12)));
		return customerDao.update(customer);
	}
	
	public Customer getAccountWithId(Integer idCustomer) {
		return customerDao.getCustomerWithId(idCustomer); 
		
	}
	

}
