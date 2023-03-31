package footprint.service;

import footprint.entity.Account;
import footprint.entity.ProductSize;

public interface CartService {
	public boolean addCart(int quantity,Account account,ProductSize productSize); 
}
