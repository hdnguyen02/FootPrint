package footprint.service;

import footprint.entity.Account;
import footprint.entity.Cart;

public interface AccountService {
	public boolean insertUser(Account user); 
	public Account getAccountByUsername(String username); 
	public Account getAccountByEmail(String email); 
	public boolean update(Account account);
	public boolean changePassword(Account account,String newPassword);
	public Account getAccountWithId(Long idAccount); 
	public Cart getCart(Long idAccount,Long idProductSize);
}
