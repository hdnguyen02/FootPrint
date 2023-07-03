package footprint.dao;

import java.util.List;

import footprint.entity.Cart;

public interface CartDao {
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public Cart getCart(Long idAccount,Long idProductSize);
	public Cart getCartWithId(Long idCart);
	public boolean deleteCart(Long idCart); 
	public List<Cart> getCartsWithIds(Long [] idCarts); 
}
