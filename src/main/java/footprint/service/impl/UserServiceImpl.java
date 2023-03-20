package footprint.service.impl;



import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.AccountDao;
import footprint.entity.Account;
import footprint.entity.Role;
import footprint.service.AccountService;

@Service
public class UserServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao; 
	
	@Override
	public boolean insertUser(Account account) {
		account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12)));
		Role role = new Role(); 
		role.setIdRole("USER");
		account.setRole(role);
		return accountDao.insert(account);
	}
	
	@Override
	public Account getAccountByUsername(String username) {
		return accountDao.getAccountByUsername(username); 
	}
	
	@Override
	public Account getAccountByEmail(String email) {
		return accountDao.getAccountByEmail(email);
	}
}
