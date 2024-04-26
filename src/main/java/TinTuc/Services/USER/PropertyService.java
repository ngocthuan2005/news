package TinTuc.Services.USER;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.DTO.User.NewDTO;
import TinTuc.Entity.Property;

@Service
public interface PropertyService {
	public List<NewDTO> getPropertyBySlug(String categorySlug, String propertySlug);
	public List<String> getDataBreadcrumby(String categorySlug, String propertySlug);
	public List<Property> getDataAllProperty();
}
