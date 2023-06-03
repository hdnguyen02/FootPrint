package footprint.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import footprint.entity.Payment;


@Repository
public class PaymentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public Payment getPaymentWidhId(String idPayment) {
		Session session = sessionFactory.getCurrentSession();
		Payment payment = (Payment) session.get(Payment.class, idPayment);
		return payment;
	}
	
	
	public List<Payment> getAllPayment() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Payment";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Payment> exports = query.list();
		return exports;
	}
	
	private static void clearTime(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}
	
	public List<Payment> filterPayment(Date fromDate, Date toDate) {
		List<Payment> payments = this.getAllPayment(); 
		List<Payment> paymentsResult = new ArrayList<>();
		
		for (Payment payment : payments) {
			
			if (fromDate == null && toDate == null) { 
				paymentsResult.add(payment);
				continue; 
			}
			
			Calendar cFrom = Calendar.getInstance();
			Calendar cTo = Calendar.getInstance();
			Calendar cDateOrder = Calendar.getInstance();

			cFrom.setTime(fromDate);
			cTo.setTime(toDate);
			cDateOrder.setTime(payment.getDate());

			clearTime(cFrom);
			clearTime(cTo);
			clearTime(cDateOrder);
			if (cDateOrder.compareTo(cFrom) >= 0 && cDateOrder.compareTo(cTo) <= 0) {
				paymentsResult.add(payment);
			}
		}
		return paymentsResult;
	}

	public boolean addPayment(Payment payment) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(payment);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}
	
	
	
	
	

}
