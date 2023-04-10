package footprint.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.OrderDao;
import footprint.entity.OrderCT;
import footprint.entity.OrderDetail;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public boolean createOrderAndOrderDetail(OrderCT order,List<OrderDetail> ordersDetail) {
		
		Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction(); 
		
		
		try { 
			session.save(order);  
			for (OrderDetail orderDetail : ordersDetail) {
				session.save(orderDetail); 
			}
			transaction.commit(); 
			return true;
		}
		catch (Exception e) {
			transaction.rollback();
			return false;
		}
		finally {
			session.close();
		}
		
	
	}

	@Override
	public boolean update(OrderCT order) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		try {
			session.update(order);
			transaction.commit();
			return true; 
		} catch (Exception e) {
			transaction.rollback();
			System.out.println(e.getMessage());
			return false; 
		} finally {
			session.close();
		}
	}
	
	@Override
	public OrderCT getOrderWidhId(Long idOrder) {
		Session session = sessionFactory.getCurrentSession(); 
		OrderCT order = (OrderCT) session.get(OrderCT.class,idOrder);
		return order; 
	}
	
	@Override
	public OrderCT getOrderWithIdOpenSS(Long idOrder) {
		Session session = sessionFactory.openSession();
		OrderCT order = (OrderCT) session.get(OrderCT.class,idOrder);
		session.close(); 
		return order;
	}
	
	@Override
	public List<OrderCT> getOrderWithDateAndStatusOrder(Date date,String idOrderStatus) throws ParseException{ // lấy ra các đơn hàng hôm nay.
	 	Session session = sessionFactory.getCurrentSession();
	 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 	String dateString = dateFormat.format(date);
	 	String hql = "FROM OrderCT order WHERE order.date >= :startDate AND order.date < :endDate AND order.orderStatus.idOrderStatus = :idOrderStatus";
	 	Query query = session.createQuery(hql);
		query.setParameter("startDate", dateFormat.parse(dateString));
	 	Calendar calendar = Calendar.getInstance();
	 	calendar.setTime(dateFormat.parse(dateString));
	 	calendar.add(Calendar.DATE, 1);
	 	query.setParameter("endDate", calendar.getTime());
	 	query.setParameter("idOrderStatus", idOrderStatus);
	 	@SuppressWarnings("unchecked")
		List<OrderCT> orders = query.list();
	 	return orders; 
 }
	

}
