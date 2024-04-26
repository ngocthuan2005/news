package TinTuc.Services.USER;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.DTO.User.NewDTO;
import TinTuc.DTO.User.NewDetailDTO;
import TinTuc.Entity.New;

@Service
public class NewServiceImp extends BaseService implements NewService{

	@Override
	public NewDetailDTO getNewDetailBySlug(String slug) {
		return newDAO.getNewDetailBySlug(slug);
	}

	@Override
	public List<NewDTO> getNewByAuthor(int author) {
		return newDAO.getNewByAuthor(author);
	}

	@Override
	public List<NewDTO> getNewByProperty(int propertyID) {
		return newDAO.getNewByProperty(propertyID);
	}

	@Override
	public New getNewBySlug(String slug) {
		return newDAO.getNewBySlug(slug);
	}
}
