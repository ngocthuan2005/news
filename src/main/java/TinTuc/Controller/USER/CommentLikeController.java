package TinTuc.Controller.USER;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import TinTuc.Entity.Comment;
import TinTuc.Entity.Like;

@Controller
public class CommentLikeController extends BaseController {
	@RequestMapping("/likes/{newSlug}/{idUser}")
	public String likeNew(HttpServletRequest request, @PathVariable String newSlug, @PathVariable int idUser) {
		List<Like> likes = _commentLikeServiceImp.checkDataLike(newSlug, idUser);
		int idNew = _newServiceImp.getNewBySlug(newSlug).getId();
		if (likes.size() > 0 && likes.get(0) != null) {
			_commentLikeServiceImp.updateLikeNew(newSlug, idUser);
		} else {
			_commentLikeServiceImp.insertLikeNew(idNew, idUser);
		}
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping("/comments/{newSlug}/{idUser}/{contentComment}")
	public String commentNew(HttpServletRequest request, @PathVariable String newSlug, @PathVariable int idUser,
			@PathVariable String contentComment) {
		List<Comment> comments = _commentLikeServiceImp.checkDataComment(newSlug, idUser);

		// Format date để lưu vào database
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//
		Date date = Date.valueOf(dateFormat.format(new Date(System.currentTimeMillis())));
		// Insert comment
		int idNew = _newServiceImp.getNewBySlug(newSlug).getId();
		_commentLikeServiceImp.insertCommentNew(idNew, idUser, contentComment, date);
		return "redirect:" + request.getHeader("Referer");
	}

}
