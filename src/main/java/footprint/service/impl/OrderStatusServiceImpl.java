package footprint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.OrderStatusDao;
import footprint.entity.OrderStatus;
import footprint.service.OrderStatusService;

@Service
public class OrderStatusServiceImpl implements OrderStatusService{
	
	
	@Autowired
	private OrderStatusDao orderStatusDao; 
	
	@Override
	public List<OrderStatus> getAllOrderStatus() {
		// TODO Auto-generated method stub
		return orderStatusDao.getAllOrderStatus();
	}
}
