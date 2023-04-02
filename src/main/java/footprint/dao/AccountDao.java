package footprint.dao;
import footprint.entity.Account;
import footprint.entity.Cart;


public interface AccountDao {
	public boolean insert(Account account); 
	public Account getAccountByUsername (String username); 
	public Account getAccountByEmail(String email); 
	public boolean update(Account account); 
	public Account getAccountWithId(Long idAccount);
	public Cart getCart(Long idAccount,Long idProductSize); 
}

