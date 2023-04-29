package footprint.dao.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.ProductDao;
import footprint.entity.Product;
import footprint.entity.ProductSize;
import footprint.entity.Size;
import footprint.entity.Thumbnail;
import footprint.service.ProductSizeService;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProductSizeService productSizeService;

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> products = query.list();
		return products;
	}

	@Override
	public boolean addProductThumbnailAndProductSize(Product product, Thumbnail[] thumbnails, List<Size> sizes,
			int[] sizesQuantity) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(product);

			for (Thumbnail thumbnail : thumbnails) {
				session.save(thumbnail);
			}
			int index = 0;
			for (Size size : sizes) {
				int quantity = sizesQuantity[index];
				ProductSize productSize = new ProductSize();
				productSize.setProduct(product);
				productSize.setSize(size);
				productSize.setQuantity(quantity);
				session.save(productSize);
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

	@Override
	public Product getProductWithId(Long idProduct) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product WHERE idProduct = :idProduct";
		Query query = session.createQuery(hql);
		query.setParameter("idProduct", idProduct);
		Product product = (Product) query.uniqueResult();
		return product;
	}

	@Override
	public Product getProductWithOpenSS(Long idProduct) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class, idProduct);
		session.close();
		return product;
	}

	@Override
	public List<Product> getProductsActive() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product WHERE disable = :disable";
		Query query = session.createQuery(hql);
		query.setParameter("disable", false);
		@SuppressWarnings("unchecked")
		List<Product> products = query.list();
		return products;
	}

	@Override
	public List<Product> searchProducts(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product where name like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + name + "%");
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		return list;
	}

	@Override
	public List<Product> filterByCategory(long idCategory) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product where idCategory like :cid";
		Query query = session.createQuery(hql);
		query.setParameter("cid", idCategory);
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		return list;
	}

	// viet ham truy van

	@Override
	public boolean updateQuantityProducts(Product product, Map<Long,Integer> pSMap) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(product);
			for (Map.Entry<Long, Integer> entryPS : pSMap.entrySet()) {
				ProductSize productSize = productSizeService.getProductSizeWithId(entryPS.getKey()); 
				productSize.setQuantity(entryPS.getValue());
				session.update(productSize);
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