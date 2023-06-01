package footprint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.entity.Export;
import footprint.entity.ExportDetail;
import footprint.entity.OrderCT;
import footprint.entity.Product;

@Repository
public class ExportDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public Export getOrderWidhId(String idExport) {
		Session session = sessionFactory.getCurrentSession();
		Export export = (Export) session.get(Export.class, idExport);
		return export;
	}

	public boolean addExportAndDetail(Export export,List<ExportDetail> exportsDetail) {
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
}
