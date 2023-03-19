package footprint.service;

import footprint.entity.Account;

public interface UserService {
	public boolean insert(Account user); 
	public Account getUserByUsername(String username); 
	public Account getUserByEmail(String email); 
}
