package footprint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.CategoryDao;
import footprint.entity.Category;
import footprint.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao; 
	private int categoryPerPage = 6; // 3 phần tử trên mỗi table 
	
	
	public List<Category> getAllCategories(){
		return categoryDao.getAllCategories(); 
	}
	
	@Override
	public int totalPage() {
		int sizeCategies = this.categoryDao.getAllCategories().size(); 
		int totalPages = (int) Math.ceil((double) sizeCategies / categoryPerPage);
		return totalPages;
	}
	
	@Override
	public List<Category> getCategoriesPerPage(int curentPage) {  
		List<Category> categories = categoryDao.getAllCategories(); 
		int sizeCategies = categories.size(); 
		int categoryPerPage = this.categoryPerPage;	 
		int startIndex = (curentPage - 1) * categoryPerPage;
		int endIndex = Math.min(startIndex + categoryPerPage, sizeCategies);
		return categories.subList(startIndex, endIndex);	
	}
	
	@Override
	public boolean insert(Category category) {
		return categoryDao.insert(category);
	}
	
	@Override
	public boolean update(Category category) {
		return categoryDao.update(category); 
	}

	
	
}
