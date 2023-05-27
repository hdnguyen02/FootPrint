package footprint.service;

import java.util.List;

import footprint.dao.AccountDao.EnumRoleID;
import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.entity.Role;

public interface AccountService {
	public boolean insertUser(Account user); 
	public Account getAccountByUsername(String username); 
	public Account getAccountByEmail(String email); 
	public boolean update(Account account);
	public boolean changePassword(Account account,String newPassword);
	public Account getAccountWithId(Long idAccount); 
	public Cart getCart(Long idAccount,Long idProductSize);
	public Role getRoleViaEnum(EnumRoleID role);
	public List<Account> listAccountWithRole(EnumRoleID idRole);
	public boolean insertStaff(Account account);
	public boolean deleteAccount(Account account);
}
