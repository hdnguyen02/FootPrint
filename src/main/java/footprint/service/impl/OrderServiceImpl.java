package footprint.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.OrderDao;
import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.entity.OrderCT;
import footprint.entity.OrderDetail;
import footprint.entity.OrderStatus;
import footprint.service.CartService;
import footprint.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CartService cartService; 
	
	// nguoi dung huy don hang 
	@Override
	public boolean orderCancel(OrderCT order) {
		String idOrderStatus = order.getOrderStatus().getIdOrderStatus(); 	 
		if (!idOrderStatus.equals("PENDING")) { 
			return false; 
		} 
		OrderStatus newOrderStatus = new OrderStatus(); 
		newOrderStatus.setIdOrderStatus("CANCEL");
		order.setOrderStatus(newOrderStatus);

		return orderDao.update(order); 
	}
	
	
	@Override
	public boolean createOrderAndOrderDetail(String firstName,String lastName,String email, String phone, String address,String message,Float totalMonney,Account account,Long [] idCarts) {
		
		
		OrderCT order = new OrderCT(); 
		order.setFirstName(firstName);
		order.setLasttName(lastName); 
		order.setEmail(email);
		order.setPhone(phone);
		order.setAddress(address);
		order.setMessage(message);
		order.setTotalMonney(totalMonney);
		
		order.setDate(new Date());
		order.setAccount(account); 
		

		OrderStatus orderStatus = new OrderStatus(); 
		orderStatus.setIdOrderStatus("PENDING"); 
		order.setOrderStatus(orderStatus);
 
		
		List<OrderDetail> ordersDetail = new ArrayList<>(); 
		
		for (Long idCart: idCarts) {
			Cart cart = cartService.getCartWithId(idCart); 
			OrderDetail orderDetail = new OrderDetail(); 
			orderDetail.setQuantity(cart.getQuantity());
			orderDetail.setCost(cart.getProductSize().getProduct().getCost()); 
			orderDetail.setTotalMonney(orderDetail.getCost() * orderDetail.getQuantity());
			orderDetail.setProductSize(cart.getProductSize());
			orderDetail.setOrder(order);
			ordersDetail.add(orderDetail); 
		}
		return orderDao.createOrderAndOrderDetail(order, ordersDetail); 
	}
	
	@Override
	public OrderCT getOrderWidhId(Long idOrder) {
		return orderDao.getOrderWidhId(idOrder); 
	}
	
	@Override
	public OrderCT getOrderWithIdOpenSS(Long idOrder) {
		return orderDao.getOrderWithIdOpenSS(idOrder); 
	}
	
	// viết 1 hàm truy vấn Các đơn hàng hôm nay. 
	
	@Override
	public List<OrderCT> getOrderWithCurentDateAndStatus(String idOrderStatus) throws ParseException { 
		 return orderDao.getOrderWithDateAndStatusOrder(new Date(), idOrderStatus); 
	}
	
	@Override
	public boolean update(OrderCT order) {
		return orderDao.update(order); 
	}


	
}
