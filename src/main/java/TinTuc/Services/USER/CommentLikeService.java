package TinTuc.Services.USER;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.DTO.User.CommentDTO;
import TinTuc.Entity.Comment;
import TinTuc.Entity.Like;

@Service
public interface CommentLikeService{
	public void insertCommentNew(int idNew, int idUser, String content, Date commentDate);
	public void insertLikeNew(int idNew, int idUser);
	public void updateCommentNew(int idNew, int idUser, String content, Date commentDate);
	public void updateLikeNew(String slug, int idUser);
	public List<Like> checkDataLike(String slug, int idUser);
	public List<Comment> checkDataComment(String slug, int idUser);
	public List<CommentDTO> getDataComments(String newSlug);
	public void deleteComment(int id);
}
