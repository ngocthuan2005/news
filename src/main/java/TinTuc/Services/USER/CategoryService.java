package TinTuc.Services.USER;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.DTO.User.NewDTO;
import TinTuc.Entity.Category;

@Service
public interface CategoryService {
	public String getBreadcrumbyByCategory(String categorySlug);
	public List<NewDTO> getDataCategoryBySlug(String slug);
	public List<NewDTO> getDataCategoryBySlug(String slug, int limit);
	public List<Category> getAllDataCategories();
}
