package TinTuc.Services.USER;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.DTO.User.NewDTO;
import TinTuc.DTO.User.NewDetailDTO;
import TinTuc.Entity.New;

@Service
public interface NewService {
	public NewDetailDTO getNewDetailBySlug(String slug);
	public List<NewDTO> getNewByAuthor(int author);
	public List<NewDTO> getNewByProperty(int propertyID);
	public New getNewBySlug(String slug);
}
