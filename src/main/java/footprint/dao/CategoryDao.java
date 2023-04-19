package footprint.dao;

import java.util.List;

import footprint.entity.Category;

public interface CategoryDao {
	public List<Category> getAllCategories (); 
	public boolean insert(Category category); 
	public boolean update(Category category);  
}	



