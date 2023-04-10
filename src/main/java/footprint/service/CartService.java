package footprint.service;

import java.util.List;

import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.entity.ProductSize;

public interface CartService {
	public boolean addCart(int quantity,Account account,ProductSize productSize); 
	public boolean updateCart(Cart cart);
	public Cart getCartWithId(Long idCart);
	public boolean deleteCart(Long idCart);
	public List<Cart> getCartsWithIds(Long [] idCarts); 
	public float computedTotalMonney(List<Cart> carts); 
}
