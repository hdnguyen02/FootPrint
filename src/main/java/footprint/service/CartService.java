package footprint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.CartDao;
import footprint.entity.Cart;
import footprint.entity.Customer;
import footprint.entity.Product;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao; 
	
	public void addCart(String idProduct,Integer idCustomer,Integer quantity) { 
		
		
		
	
		Cart cart =cartDao.getCart(idProduct, idCustomer);
		if (cart != null) { // đã tồn tại rồi. 
			cart.setQuantity(cart.getQuantity() + quantity); 
			cartDao.updateCart(cart);
			return; 
		}
		cart = new Cart(); 
		Customer customer = new Customer(); 
		customer.setIdCustomer(idCustomer);
		Product product = new Product(); 
		product.setIdProduct(idProduct);
		cart.setCustomer(customer);
		cart.setProduct(product); 
		cart.setQuantity(quantity);
		cartDao.addCart(cart);
	}
	
	public Cart getCartWithId(Integer idCart) { 
		return cartDao.getCartWithId(idCart); 
	}
	
	public void updateCart(Cart cart) { 
		cartDao.updateCart(cart);
	}
	
	public void deleteCart(Integer idCart) {
		cartDao.deleteCart(idCart);
	}
	
	public List<Cart> getCartsWithIds(Integer [] idCarts){
		return cartDao.getCartsWithIds(idCarts);
	}
	
	public float computedTotalMonney(List<Cart> carts) { 
		float totalMonney = 0f; 
		for (Cart cart : carts) {
			totalMonney+= cart.getQuantity() * cart.getProduct().getCost(); 
		}
		return totalMonney; 
	}
}
