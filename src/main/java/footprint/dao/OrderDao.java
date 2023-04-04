package footprint.dao;

import java.util.List;

import footprint.entity.OrderCT;
import footprint.entity.OrderDetail;

public interface OrderDao {
	// tạo đơn hàng và chi tiết đơn hàng cùng 1 lúc. 
	public boolean createOrderAndOrderDetail(OrderCT order,List<OrderDetail> orderDetail); 
}
