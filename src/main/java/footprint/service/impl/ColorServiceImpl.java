package footprint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.ColorDao;
import footprint.entity.Color;
import footprint.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {
	
	@Autowired
	private ColorDao colorDao;
	
	@Override
	public List<Color> getAllColors() {
		return colorDao.getAllColors();
	}
}
