package footprint.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.ProductSizeDao;
import footprint.entity.ProductSize;


@Repository
@Transactional
public class ProductSizeDaoImpl implements ProductSizeDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProductSize> getProductSizeWithIdProduct(Long idProduct) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ProductSize where idProduct = :idProduct";
		Query query = session.createQuery(hql);
		query.setParameter("idProduct", idProduct);
		
		try {
			return (List<ProductSize>) query.list();
		}
		catch(Exception e) {
			return null;
		}
	}
	
}