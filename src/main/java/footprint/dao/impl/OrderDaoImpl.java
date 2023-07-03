package footprint.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
	
	// truy vấn ra số lượng đơn hàng thuộc ngày -> không quan trọng trạng thái 
	@Override
	public List<OrderCT> getOrderWithDate(Date date) throws ParseException{ // lấy ra các đơn hàng hôm nay.
	 	Session session = sessionFactory.getCurrentSession();
	 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 	String dateString = dateFormat.format(date);
	 	String hql = "FROM OrderCT order WHERE order.date >= :startDate AND order.date < :endDate";
	 	Query query = session.createQuery(hql);
		query.setParameter("startDate", dateFormat.parse(dateString));
	 	Calendar calendar = Calendar.getInstance();
	 	calendar.setTime(dateFormat.parse(dateString));
	 	calendar.add(Calendar.DATE, 1);
	 	query.setParameter("endDate", calendar.getTime());
	 	@SuppressWarnings("unchecked")
		List<OrderCT> orders = query.list();
	 	return orders; 
	}
	
	@Override
	public List<OrderCT> getOrderWithDateAndStatus(Date date,String idOrderStatus) throws ParseException{ // lấy ra các đơn hàng hôm nay.
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
	
	// truy vấn với month: 
	@Override
	public List<OrderCT> getOrderWithMonthAndStatus(Date date,String idOrderStatus) { 
		Session session = sessionFactory.getCurrentSession();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		String sql = "SELECT * FROM OrderCT WHERE MONTH(date) = :month AND YEAR(date) = :year AND idOrderStatus = :idOrderStatus";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("month", month);
		query.setParameter("year", year);
		query.setParameter("idOrderStatus", idOrderStatus);
		query.addEntity(OrderCT.class);
		@SuppressWarnings("unchecked")
		List<OrderCT> orders = query.list();
		return orders;
	}
	
	@Override
	public List<OrderCT> getOrderWithMonth(Date date) { 
		Session session = sessionFactory.getCurrentSession();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		String sql = "SELECT * FROM OrderCT WHERE MONTH(date) = :month AND YEAR(date) = :year";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("month", month);
		query.setParameter("year", year);
		query.addEntity(OrderCT.class);
		@SuppressWarnings("unchecked")
		List<OrderCT> orders = query.list();
		return orders;
	}
	
	

}
