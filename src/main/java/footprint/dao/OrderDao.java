package footprint.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import footprint.entity.OrderCT;
import footprint.entity.OrderDetail;

public interface OrderDao {
	// tạo đơn hàng và chi tiết đơn hàng cùng 1 lúc. 
	public boolean createOrderAndOrderDetail(OrderCT order,List<OrderDetail> orderDetail); 
	public OrderCT getOrderWidhId(Long idOrder); 
	public boolean update(OrderCT order); 
	public OrderCT getOrderWithIdOpenSS(Long idOrder);
	public List<OrderCT> getOrderWithDateAndStatus(Date date,String idOrderStatus) throws ParseException;
	public List<OrderCT> getOrderWithDate(Date date) throws ParseException;
	public List<OrderCT> getOrderWithMonthAndStatus(Date date,String idOrderStatus); 
	public List<OrderCT> getOrderWithMonth(Date date); 
}
