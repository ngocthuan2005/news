package TinTuc.Services.USER;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.DTO.User.NewDTO;
import TinTuc.Entity.Category;
import TinTuc.Entity.New;
import TinTuc.Entity.Property;

@Service
public interface HomeService {
	public List<Category> getDataCategories();
	public List<Property> getDataProperties();
	public List<New> getDataNewUpdate();
	public List<NewDTO> getDataLimitSix();
	public List<NewDTO> getAllDataNewByCategory();
}
