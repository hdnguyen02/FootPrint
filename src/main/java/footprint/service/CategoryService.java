package footprint.service;

import java.util.List;

import footprint.entity.Category;

public interface CategoryService {
	public List<Category> getAllCategories(); 
	
	public int totalPage(); 
	
	public List<Category> getCategoriesPerPage(int curentPage); 
	public boolean insert(Category category); 
	
	
}
