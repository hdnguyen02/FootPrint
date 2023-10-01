package footprint.dao; 

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.entity.Product;
import footprint.entity.Thumbnail;

@Repository
@Transactional
public class ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> products = query.list();
		return products;
	}
	
	
	public boolean addProductAndThumbnail(Product product, Thumbnail[] thumbnails) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(product);
			for (Thumbnail thumbnail : thumbnails) {
	
				session.save(thumbnail);
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
	
	public Product getProductWithId(String idProduct) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class, idProduct);
		session.close();
		return product;
	}
	
	public Product getProductCurentSS(String idProduct) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product WHERE idProduct = :idProduct";
		Query query = session.createQuery(hql);
		query.setParameter("idProduct", idProduct);
		Product product = (Product) query.uniqueResult();
		return product;
	}
	
	
	public List<Product> getProductsActive() { 
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product WHERE disable = :disable";
		Query query = session.createQuery(hql);
		query.setParameter("disable", false);
		@SuppressWarnings("unchecked")
		List<Product> products = query.list();
		return products;
	}
	
	
	public boolean update(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(product);
			
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
	
	public List<Product> searchProducts(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product where name like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + name + "%"); 
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		return list;
	}
	
	public List<Product> filterByCategory(String idCategory) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product where idCategory like :cid";
		Query query = session.createQuery(hql);
		query.setParameter("cid", "%" + idCategory + "%");
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		return list;
	}
	
	public List<Product> filterByPrice(float min, float max) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product where cost between :min and :max";
		Query query = session.createQuery(hql);
		query.setParameter("min", min);
		query.setParameter("max", max);
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		return list;
	}
	
	public List<Product> filterByColor(String color) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product where color like :color";
		Query query = session.createQuery(hql);
		query.setParameter("color", "%" + color + "%");
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		return list;
	}
	
	public List<Product> filterBySize(String size) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product where size like :size";
		Query query = session.createQuery(hql);
		query.setParameter("size", "%" + size + "%");
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		return list;		
	}
	
}
