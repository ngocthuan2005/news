package TinTuc.Services.USER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TinTuc.DAO.CategoryDAO;
import TinTuc.DAO.NewDAO;
import TinTuc.DAO.PropertyDAO;
import TinTuc.DTO.User.NewDTO;
import TinTuc.Entity.Category;
import TinTuc.Entity.New;
import TinTuc.Entity.Property;

@Service
public class HomeServiceImp extends BaseService implements HomeService {

	@Override
	public List<Category> getDataCategories() {
		return categoryDAO.getDataCategories();
	}

	@Override
	public List<Property> getDataProperties() {
		List<Property> list = propertyDAO.getAllProperty();
		return list;
	}

	@Override
	public List<New> getDataNewUpdate() {
		return newDAO.getDataNewUpdate();
	}

	@Override
	public List<NewDTO> getDataLimitSix() {
		return newDAO.getDataLimitSix();
	}

	@Override
	public List<NewDTO> getAllDataNewByCategory() {
		return categoryDAO.getAllDataNewByCategory();
	}
}
