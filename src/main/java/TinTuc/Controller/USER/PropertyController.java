package TinTuc.Controller.USER;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PropertyController extends BaseController{
	
	@RequestMapping("/{slugCategory}/{slugProperty}")
	public ModelAndView propertyDetail(@PathVariable String slugCategory, @PathVariable String slugProperty) {
		_mvShare.addObject("slugCategory", slugCategory);
		_mvShare.addObject("propertyBySlugs", _propertyServiceImp.getPropertyBySlug(slugCategory, slugProperty));
		List<String> list = _propertyServiceImp.getDataBreadcrumby(slugCategory, slugProperty);
		_mvShare.addObject("categpryTitle", list.get(0));
		_mvShare.addObject("propertyTitle", list.get(1));
		_mvShare.setViewName("user/property");
		return _mvShare;
	}
	
}
