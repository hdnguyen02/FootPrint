package footprint.dao;
import java.util.List;

import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.entity.Role;

public interface AccountDao {
	public static enum EnumRoleID {
		USER, ADMIN, STAFF,
	}
	public boolean insert(Account account); 
	public Account getAccountByUsername (String username); 
	public Account getAccountByEmail(String email); 
	public boolean update(Account account); 
	public Account getAccountWithId(Long idAccount);
	public List<Account> listAccountWithRole(EnumRoleID idRole);
	public Cart getCart(Long idAccount,Long idProductSize); 
	public boolean deleteAccount(Account account);
	public Role getRoleViaEnum(EnumRoleID role);
}

