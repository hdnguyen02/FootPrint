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
	
	// lấy ve productSize đó 
	@Override
	public ProductSize getProductSize(Long idProduct,String idSize) {
			Session session = sessionFactory.getCurrentSession(); 
			String hql = "FROM ProductSize WHERE idProduct = :idProduct AND idSize = :idSize";
			Query query = session.createQuery(hql);
			query.setParameter("idProduct", idProduct);
			query.setParameter("idSize", idSize);
			return  (ProductSize) query.uniqueResult();
	}
	
	@Override
	public ProductSize getProductSizeWithId(Long idProductSize) {
		Session session = sessionFactory.openSession();
		ProductSize productSize = (ProductSize) session.get(ProductSize.class,idProductSize); 
		return productSize; 
	}
	
	
}
