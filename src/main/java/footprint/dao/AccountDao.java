package footprint.dao;
import footprint.entity.Account;


public interface AccountDao {
	public boolean insert(Account account); 
	public Account getAccountByUsername (String username); 
	public Account getAccountByEmail(String email); 
	public boolean update(Account account); 
}
