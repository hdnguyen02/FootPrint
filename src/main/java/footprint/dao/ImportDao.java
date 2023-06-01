package footprint.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.entity.Import;
import footprint.entity.ImportDetail;
import footprint.entity.Product;


@Repository
@Transactional
public class ImportDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public boolean addImportAndDetail(Import importEntity,ImportDetail [] importDetails,Product [] productsUpdate) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(importEntity);
			int index = 0; 
			for (ImportDetail importDetail : importDetails) {
				productsUpdate[index].setQuantity(productsUpdate[index].getQuantity() + importDetail.getQuantity());
				session.save(importDetail); 
				session.update(productsUpdate[index]); 
				index++; 
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

}
