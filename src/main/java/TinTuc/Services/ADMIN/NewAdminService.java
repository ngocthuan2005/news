package TinTuc.Services.ADMIN;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.DTO.Admin.CommentDTOAdmin;
import TinTuc.DTO.Admin.NewDTOAdmin;
import TinTuc.DTO.User.NewDetailDTO;
import TinTuc.Entity.New;

@Service
public interface NewAdminService{
	public List<CommentDTOAdmin> getCommentToCensorship();
	public List<CommentDTOAdmin> getDataComments(int start, int totalOnOnePage);	
	public List<NewDTOAdmin> getDataNewAdminAll();
	public List<NewDTOAdmin> getDataNewAdminAll(int start, int totalOnOnePage);
	public List<NewDTOAdmin> getDataNewAdminByIDAuthor(int idAuthor);
	public void insertNew(String title, String slug, String summary, String content, int author, String posting_date, String image, String video, int id_property, int id_category);
	public void updateNew(int id, String title, String slug, String summary, String content, String posting_date, String approval_date, String image, String video, int id_property, int id_category);
	public void updateNew(int id, boolean status);
	public void deleteNew(int id);	
	public NewDetailDTO getNewDetailAdmin(int id);
	public New getNewByID(int id);
}
