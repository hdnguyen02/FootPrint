package footprint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.UserDao;
import footprint.entity.UserEntity;
import footprint.service.UserService;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao; 
	

	public List<UserEntity> getUsers() {
		
		return this.userDao.getUsers(); 
	}
}
