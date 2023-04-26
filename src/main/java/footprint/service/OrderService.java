package footprint.service;


import java.text.ParseException;
import java.util.List;

import footprint.entity.Account;
import footprint.entity.OrderCT;

public interface OrderService {
	public boolean createOrderAndOrderDetail(String firstName,String lastName,String email, String phone, String address,String message,Float totalMonney,Account account,Long [] idCarts);
	public OrderCT getOrderWidhId(Long idOrder);  
	public OrderCT getOrderWithIdOpenSS(Long idOrder);
	public boolean orderCancel(OrderCT order);
	public List<OrderCT> getOrderWithCurentDateAndStatus(String idOrderStatus) throws ParseException;
	
	public boolean update(OrderCT order);

	public boolean createOrderAndOrderDetailNotAccount(String firstName,String lastName,String email, String phone, String address,String message,Float totalMonney,String [] idPSAndQuantitys);
	public List<OrderCT> getOrderWithCurentMonthAndStatus(String idOrderStatus); 
}
