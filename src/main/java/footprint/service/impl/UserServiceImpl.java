package footprint.service.impl;



import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.UserDao;
import footprint.entity.Account;
import footprint.entity.Role;
import footprint.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao; 
	
	@Override
	public boolean insert(Account account) {
		account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12)));
		Role role = new Role(); 
		role.setIdRole("USER");
		account.setRole(role);
		return userDao.insert(account);
	}
}
