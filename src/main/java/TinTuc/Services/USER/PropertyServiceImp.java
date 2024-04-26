package TinTuc.Services.USER;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.DTO.User.NewDTO;
import TinTuc.Entity.Property;

@Service
public class PropertyServiceImp extends BaseService implements PropertyService {
	
	public List<NewDTO> getPropertyBySlug(String categorySlug, String propertySlug) {
		List<NewDTO> list = propertyDAO.getPropertyBySlug(categorySlug, propertySlug);
		if(list.size() ==0) {
			return null;
		}
		return list;
	}

	@Override
	public List<String> getDataBreadcrumby(String categorySlug, String propertySlug) {
		return propertyDAO.getDataBreadcrumby(categorySlug, propertySlug);
	}

	@Override
	public List<Property> getDataAllProperty() {
		return propertyDAO.getAllProperty();
	}
}
