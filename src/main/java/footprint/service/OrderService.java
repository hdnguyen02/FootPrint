package footprint.service;


import footprint.entity.Account;

public interface OrderService {
	public boolean createOrderAndOrderDetail(String firstName,String lastName,String email, String phone, String address,String message,Float totalMonney,Account account,Long [] idCarts);
}
