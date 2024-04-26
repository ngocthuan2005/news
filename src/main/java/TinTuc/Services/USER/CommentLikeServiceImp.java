package TinTuc.Services.USER;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.DTO.User.CommentDTO;
import TinTuc.Entity.Comment;
import TinTuc.Entity.Like;

@Service
public class CommentLikeServiceImp extends BaseService implements CommentLikeService{

	@Override
	public void insertCommentNew(int idNew, int idUser, String content, Date commentDate) {
		commentLikeDAO.insertCommentNew(idNew, idUser, content, commentDate);
	}

	@Override
	public void updateCommentNew(int idNew, int idUser, String content, Date commentDate) {
		commentLikeDAO.updateCommentNew(idNew, idUser, content, commentDate);
	}

	@Override
	public void updateLikeNew(String newSlug, int idUser) {
		boolean checkLike = checkDataLike(newSlug, idUser).get(0).isLike();
		if(checkLike == true) {
			commentLikeDAO.updateLikeNew(newSlug, idUser, false);
		}else if(checkLike == false) {
			commentLikeDAO.updateLikeNew(newSlug, idUser, true);
		}
	}

	@Override
	public void insertLikeNew(int idNew, int idUser) {
		commentLikeDAO.insertLikeNew(idNew, idUser);
	}

	@Override
	public List<Like> checkDataLike(String idNew, int idUser) {
		return commentLikeDAO.checkDataLike(idNew, idUser);
	}

	@Override
	public List<Comment> checkDataComment(String idNew, int idUser) {
		return commentLikeDAO.checkDataComment(idNew, idUser);
	}

	@Override
	public List<CommentDTO> getDataComments(String newSlug) {
		return commentLikeDAO.getDataComments(newSlug);
	}

	@Override
	public void deleteComment(int id) {
		commentLikeDAO.delete(id);
	}
}
