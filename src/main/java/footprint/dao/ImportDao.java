package footprint.dao;

import java.util.ArrayList;
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

import footprint.entity.Import;
import footprint.entity.ImportDetail;
import footprint.entity.Product;

@Repository
@Transactional
public class ImportDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addImportAndDetail(Import importEntity, ImportDetail[] importDetails, Product[] productsUpdate) {

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

	public List<Import> getAllImports() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Import";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Import> imports = query.list();
		return imports;
	}

	// Viết ra 1 hàm lặp
	private static void clearTime(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	public List<Import> filterImport(Date fromDate, Date toDate) {
		List<Import> imports = this.getAllImports();
		List<Import> importsResult = new ArrayList<>();
		for (Import importEntity : imports) {
			Calendar cFrom = Calendar.getInstance();
			Calendar cTo = Calendar.getInstance();
			Calendar cDateOrder = Calendar.getInstance();

			cFrom.setTime(fromDate);
			cTo.setTime(toDate);
			cDateOrder.setTime(importEntity.getDate());

			clearTime(cFrom);
			clearTime(cTo);
			clearTime(cDateOrder);
			if (cDateOrder.compareTo(cFrom) >= 0 && cDateOrder.compareTo(cTo) <= 0) {
				importsResult.add(importEntity);
			}

		}

		return importsResult;

	}
	
	public Import getImportWithId(String idImport) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Import WHERE idImport = :idImport";
		Query query = session.createQuery(hql);
		query.setParameter("idImport", idImport);
		Import importEntity = (Import) query.uniqueResult();
		return importEntity;
	}
	

}
