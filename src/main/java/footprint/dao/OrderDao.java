package footprint.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.entity.OrderCT;
import footprint.entity.OrderDetail;

@Repository
@Transactional
public class OrderDao {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean createOrderAndOrderDetail(OrderCT order, List<OrderDetail> ordersDetail) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(order);
			for (OrderDetail orderDetail : ordersDetail) {
				session.save(orderDetail);
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}

	}

	public OrderCT getOrderWidhId(Integer idOrder) {
		
		Session session = sessionFactory.getCurrentSession(); 
		OrderCT order = (OrderCT) session.get(OrderCT.class, idOrder);  
		return order;
	}

	public OrderCT getOrderWithIdOpenSS(Integer idOrder) {
		Session session = sessionFactory.openSession();
		OrderCT order = (OrderCT) session.get(OrderCT.class, idOrder);
		session.close();
		return order;
	}

	public List<OrderCT> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from OrderCT";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<OrderCT> orders = query.list();
		return orders;
	}

	// viết 1 hàm lọc
	private static void clearTime(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	public List<OrderCT> filterOrders(Date fromDate, Date toDate, boolean isExistExport) {
		List<OrderCT> orders = this.getAllOrders();

		List<OrderCT> orderResult = new ArrayList<>();

		for (OrderCT order : orders) {
			if (isExistExport == true && order.getExport() == null) {

				continue;
			} else if (isExistExport == false && order.getExport() != null) {
				continue;
			}
			if (fromDate == null && toDate == null) {
				orderResult.add(order);
				continue;
			}

			Calendar cFrom = Calendar.getInstance();
			Calendar cTo = Calendar.getInstance();
			Calendar cDateOrder = Calendar.getInstance();

			cFrom.setTime(fromDate);
			cTo.setTime(toDate);
			cDateOrder.setTime(order.getDate());

			clearTime(cFrom);
			clearTime(cTo);
			clearTime(cDateOrder);

			if (cDateOrder.compareTo(cFrom) >= 0 && cDateOrder.compareTo(cTo) <= 0) {
				orderResult.add(order);
			}

		}

		return orderResult;

	}

}
