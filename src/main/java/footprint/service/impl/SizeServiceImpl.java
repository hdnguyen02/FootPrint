package footprint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.SizeDao;
import footprint.entity.Size;
import footprint.service.SizeService;


@Service
public class SizeServiceImpl implements SizeService {
	
	@Autowired
	private SizeDao sizeDao;
	
	@Override
	public List<Size> getAllSizes() {
		return sizeDao.getAllSizes();
	}
}	
