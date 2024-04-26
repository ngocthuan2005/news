package TinTuc.Controller.USER;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import TinTuc.DTO.User.NewDTO;
import TinTuc.Entity.Category;

@Controller
public class HomeController extends BaseController {
	@RequestMapping(value = "/")
	public ModelAndView index() {
		_mvShare.setViewName("user/index");
		_mvShare.addObject("newSixs", _homeServiceImp.getDataLimitSix());
        
		List<Category> categoriesTemp = _homeServiceImp.getDataCategories();
		List<NewDTO> news = _homeServiceImp.getAllDataNewByCategory();
		
		List<Integer> list = new ArrayList<>();
		
		for (NewDTO newDTO : news) {
			list.add(newDTO.getIdCategory());
		}
		
        Set<Integer> uniqueElements = new HashSet<>(list);
        List<Integer> filteredCategoryId = new ArrayList<>(uniqueElements);
        
        list.clear();
        list = null;
        
		List<Category> categories = new ArrayList<>();
		for (Integer integer : filteredCategoryId) {
			for (Category category : categoriesTemp) {
				if(integer.equals(category.getId())) {
					categories.add(category);
				}
			}
		}
		
		filteredCategoryId.clear();
		filteredCategoryId = null;
		
		_mvShare.addObject("categoriesNews", categories);
		_mvShare.addObject("allNewByCategories", news);
		return _mvShare;
	}
}
