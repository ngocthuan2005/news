package TinTuc.Controller.USER;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import TinTuc.DTO.User.NewDTO;
import TinTuc.Entity.Property;

@Controller
@RequestMapping(value = "/")
public class CategoryController extends BaseController {
	@RequestMapping(value = "{slugCategory}")
	public ModelAndView categoryDetail(@PathVariable String slugCategory) {
		List<Property> properties = new ArrayList<>();
		String breadCrumby = _categoryServiceImp.getBreadcrumbyByCategory(slugCategory);
		List<NewDTO> list = _categoryServiceImp.getDataCategoryBySlug(slugCategory);
		List<Property> listProperties = _propertyServiceImp.getDataAllProperty();
		List<NewDTO> listLimit = _categoryServiceImp.getDataCategoryBySlug(slugCategory, 9);

		for (NewDTO newDTO : list) {
			for (Property property : listProperties) {
				if (newDTO.getIdProperty() == property.getId()) {
					properties.add(property);
				}
			}
		}

		if (properties.size() >= 2) {
			for (int i = 0; i < properties.size() - 1; i++) {
				for (int j = 1; j < properties.size(); j++) {
					if (properties.get(i).getId() == properties.get(j).getId()) {
						properties.remove(j);
					}
				}
			}
		}

		_mvShare.addObject("breadCrumby", breadCrumby);
		_mvShare.addObject("propertiesForCategory", properties);
		_mvShare.addObject("categoryBySlugs", list);
		_mvShare.addObject("categoryBySlugsLimits", listLimit);
		_mvShare.setViewName("user/category");
		return _mvShare;
	}
}
