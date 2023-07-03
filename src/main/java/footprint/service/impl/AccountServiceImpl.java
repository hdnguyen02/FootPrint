package footprint.service.impl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.AccountDao;
import footprint.dao.AccountDao.EnumRoleID;
import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.entity.Role;
import footprint.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
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
	public boolean insertStaff(Account account) {
		account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12)));
		Role role = new Role(); 
		role.setIdRole("STAFF");
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
	@Override
	public boolean update(Account account) {
		return accountDao.update(account);
	}
	
	// thay đổi mật khẩu: 
	@Override
	public boolean changePassword(Account account,String newPassword) {
		account.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(12)));
		return accountDao.update(account);
	}
	
	@Override
	public Account getAccountWithId(Long idAccount) {
		return accountDao.getAccountWithId(idAccount); 
	}
	
	@Override
	public Cart getCart(Long idAccount, Long idProductSize) {
		return accountDao.getCart(idAccount, idProductSize); 
	}
	
	@Override
	public List<Account> listAccountWithRole(EnumRoleID idRole) {
		return accountDao.listAccountWithRole(idRole);
	}
	
	@Override
	public Role getRoleViaEnum(EnumRoleID role) {
		return accountDao.getRoleViaEnum(role);
	}
	
	@Override
	public boolean deleteAccount(Account account) {
		return accountDao.deleteAccount(account);
	}
}
