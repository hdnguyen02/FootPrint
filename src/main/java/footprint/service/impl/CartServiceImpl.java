package footprint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.CartDao;
import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.entity.ProductSize;
import footprint.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired 
	private CartDao cartDao; 

	
	@Override
	public boolean addCart(int quantity,Account account,ProductSize productSize) { 
		
		

		Cart cart = new Cart(); 
		cart.setQuantity(quantity);
		cart.setAccount(account);
		cart.setProductSize(productSize);
		return cartDao.addCart(cart);
	}
	
	@Override
	public boolean updateCart(Cart cart) {
		return cartDao.updateCart(cart);
	}
	
	@Override
	public Cart getCartWithId(Long idCart) {
		return cartDao.getCartWithId(idCart);
	}
	
	@Override
	public boolean deleteCart(Long idCart) {
		return cartDao.deleteCart(idCart);
	}
	
	
}
