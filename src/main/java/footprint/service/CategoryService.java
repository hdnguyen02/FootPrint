package footprint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.CategoryDao;
import footprint.entity.Category;


@Service
public class CategoryService{
	
	@Autowired private CategoryDao categoryDao;  
	

	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}
	
	private int categoryPerPage = 12; 
	
	

	public int totalPage() {
		int sizeCategies = this.categoryDao.getAllCategories().size(); 
		int totalPages = (int) Math.ceil((double) sizeCategies / categoryPerPage);
		return totalPages;
	}
	
	public List<Category> getCategoriesPerPage(int curentPage) {  
		List<Category> categories = categoryDao.getAllCategories(); 
		int sizeCategies = categories.size(); 
		int categoryPerPage = this.categoryPerPage;	 
		int startIndex = (curentPage - 1) * categoryPerPage;
		int endIndex = Math.min(startIndex + categoryPerPage, sizeCategies);
		return categories.subList(startIndex, endIndex);	
	}
	
	public boolean insert(Category category) {
		return categoryDao.insert(category);
	}
	
	public boolean update(Category category) {
		return categoryDao.update(category); 
	}

	public Category getCategoryWithId(String idCategory) { 
		return categoryDao.getCategoryWithId(idCategory); 
	}
	
	
}
