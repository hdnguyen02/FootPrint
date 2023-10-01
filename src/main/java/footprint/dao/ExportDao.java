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

import footprint.entity.Export;
import footprint.entity.ExportDetail;

import footprint.entity.Product;

@Repository
public class ExportDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Export getExportWidhId(String idExport) {
		Session session = sessionFactory.getCurrentSession();
		Export export = (Export) session.get(Export.class, idExport);
		return export;
	}

	public List<Export> getAllExports() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Export";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Export> exports = query.list();
		return exports;
	}

	private static void clearTime(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	public List<Export> filterExport(Date fromDate, Date toDate) {
		List<Export> exports = this.getAllExports();
		List<Export> exportsResult = new ArrayList<>();

		for (Export export : exports) {

			if (fromDate == null && toDate == null) {
				exportsResult.add(export);
				continue;
			}

			Calendar cFrom = Calendar.getInstance();
			Calendar cTo = Calendar.getInstance();
			Calendar cDateOrder = Calendar.getInstance();

			cFrom.setTime(fromDate);
			cTo.setTime(toDate);
			cDateOrder.setTime(export.getDate());

			clearTime(cFrom);
			clearTime(cTo);
			clearTime(cDateOrder);
			if (cDateOrder.compareTo(cFrom) >= 0 && cDateOrder.compareTo(cTo) <= 0) {
				exportsResult.add(export);
			}

		}

		return exportsResult;

	}

	public boolean addExportAndDetail(Export export, List<ExportDetail> exportsDetail) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(export);
			for (ExportDetail exportDetail : exportsDetail) {
				Product productUpdate = exportDetail.getProduct();
				Integer quantityUpdate = productUpdate.getQuantity() - exportDetail.getQuantity();
				if (quantityUpdate < 0) {
					throw new Exception("Số lượng không đủ");
				}
				productUpdate.setQuantity(quantityUpdate);
				session.save(exportDetail);
				session.update(productUpdate);
			}
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

	// lấy ra các phiếu xuất chưa có thanh toán
	public List<Export> getExportsNotPayment() {
		List<Export> exports = this.getAllExports();
		List<Export> exportsResult = new ArrayList<>();
		for (Export export : exports) {
			if (export.getPayment() == null) {
				exportsResult.add(export);
			}
		}
		return exportsResult;
	}

}
