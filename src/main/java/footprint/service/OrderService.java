package footprint.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.OrderDao;
import footprint.entity.Cart;
import footprint.entity.Customer;
import footprint.entity.OrderCT;
import footprint.entity.OrderDetail;

@Service
public class OrderService {
	
	@Autowired
	private CartService cartService; 
	
	
	@Autowired 
	private OrderDao orderDao; 
	
	
	public boolean createOrderAndOrderDetail(String firstName,String lastName,String email, String phone, String address,String message,Float totalMonney,Integer idCustomer,Integer [] idCarts) {
		OrderCT order = new OrderCT(); 
		order.setFirstName(firstName);
		order.setLastName(lastName); 
		order.setEmail(email);
		order.setPhone(phone);
		order.setAddress(address);
		order.setMessage(message);
		order.setTotalMonney(totalMonney);
		
		order.setIsCancelled(false);  
		
		order.setDate(new Date()); 
		
		Customer customer = new Customer(); 
		customer.setIdCustomer(idCustomer);
		order.setCustomer(customer); 
	
 
		List<OrderDetail> ordersDetail = new ArrayList<>(); 
		for (Integer idCart: idCarts) {
			Cart cart = cartService.getCartWithId(idCart); 
			OrderDetail orderDetail = new OrderDetail(); 
			orderDetail.setQuantity(cart.getQuantity());
			orderDetail.setCost(cart.getProduct().getCost()); 
			orderDetail.setProduct(cart.getProduct());;
			orderDetail.setOrder(order);
			ordersDetail.add(orderDetail); 
		}
		return orderDao.createOrderAndOrderDetail(order, ordersDetail); 
	}
	public List<OrderCT> getAllOrders(){ 
		return orderDao.getAllOrders(); 
	}
	public List<OrderCT> filterOrders(Date fromDate, Date toDate,boolean isExistExport){
		return orderDao.filterOrders(fromDate, toDate, isExistExport);
	}
	public OrderCT getOrderWidhId(Integer idOrder) {
		return orderDao.getOrderWidhId(idOrder); 
	}
	
	public OrderCT getOrderWithIdOpenSS(Integer idOrder) {
		return orderDao.getOrderWithIdOpenSS(idOrder); 
	}
	
	public void update(OrderCT order) { 
		orderDao.update(order);
		
	}
	
	
	
	
	
	
}
