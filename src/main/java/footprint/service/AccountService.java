package footprint.service;

import footprint.entity.Account;

public interface AccountService {
	public boolean insertUser(Account user); 
	public Account getAccountByUsername(String username); 
	public Account getAccountByEmail(String email); 
	public boolean update(Account account);
	public boolean changePassword(Account account,String newPassword);
}