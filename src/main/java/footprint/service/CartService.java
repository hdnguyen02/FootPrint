package footprint.service;

import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.entity.ProductSize;

public interface CartService {
	public boolean addCart(int quantity,Account account,ProductSize productSize); 
	public boolean updateCart(Cart cart);
	public Cart getCartWithId(Long idCart);
	public boolean deleteCart(Long idCart);
}
