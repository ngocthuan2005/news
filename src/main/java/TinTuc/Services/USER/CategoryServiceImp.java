package TinTuc.Services.USER;

import java.util.List;
import org.springframework.stereotype.Service;

import TinTuc.DTO.User.NewDTO;
import TinTuc.Entity.Category;

@Service
public class CategoryServiceImp extends BaseService implements CategoryService{

	@Override
	public String getBreadcrumbyByCategory(String categorySlug) {
		return categoryDAO.getBreadcrumby(categorySlug);
	}

	@Override
	public List<NewDTO> getDataCategoryBySlug(String slug) {
		return categoryDAO.getDataCategoryBySlug(slug);
	}

	@Override
	public List<NewDTO> getDataCategoryBySlug(String slug, int limit) {
		return categoryDAO.getDataCategoryBySlug(slug, limit);
	}

	@Override
	public List<Category> getAllDataCategories() {
		return categoryDAO.getDataCategories();
	}

	
}
