package TinTuc.Controller.ADMIN;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import TinTuc.DTO.PaginatesDTO;
import TinTuc.DTO.Admin.CommentDTOAdmin;
import TinTuc.DTO.Admin.NewDTOAdmin;
import TinTuc.Services.PaginatesServiceImp;

@Controller
@RequestMapping("/admin/new-admin/censorship-new")
//Người kiểm duyệt: duyệt tin, check bình luận
public class CensorshipController extends BaseAdminController {
	
	// phan trang
	@Autowired
	PaginatesServiceImp paginatesServiceImp;
	private final int totalOnOnePage = 10;
	
	@RequestMapping("/")
	public ModelAndView index() {
		_mvShare.setViewName("admin/censorship/news-censorship-all");
		PaginatesDTO paginateInfo = paginatesServiceImp.getInfoPaginate(newAdminServiceImp.getDataNewAdminAll().size(),
				totalOnOnePage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		List<NewDTOAdmin> newDTOAdmins = newAdminServiceImp.getDataNewAdminAll(paginateInfo.getStartPage(),
				totalOnOnePage);
		_mvShare.addObject("newAdmins", newDTOAdmins);
		return _mvShare;
	}

	@RequestMapping("/news/pages/{page}")
	public ModelAndView index(@PathVariable int page) {
		_mvShare.setViewName("admin/censorship/news-censorship-all");
		PaginatesDTO paginateInfo = paginatesServiceImp.getInfoPaginate(newAdminServiceImp.getDataNewAdminAll().size(),
				totalOnOnePage, page);
		_mvShare.addObject("paginateInfo", paginateInfo);
		List<NewDTOAdmin> newDTOAdmins = newAdminServiceImp.getDataNewAdminAll(paginateInfo.getStartPage(),
				totalOnOnePage);
		_mvShare.addObject("newAdmins", newDTOAdmins);
		return _mvShare;
	}
	
	@RequestMapping("/detail-censorship/{role}/{idNew}")
	public ModelAndView detailCensorship(@PathVariable int role, @PathVariable int idNew) {
		_mvShare.setViewName("admin/censorship/new-censorship-detail");
		_mvShare.addObject("idNew", idNew);
		_mvShare.addObject("newDetail", newAdminServiceImp.getNewDetailAdmin(idNew));
		return _mvShare;
	}

	@RequestMapping("/checkCommentAll/")
	public ModelAndView checkComments() {
		_mvShare.setViewName("admin/censorship/comments");
		PaginatesDTO paginateInfo = paginatesServiceImp
				.getInfoPaginate(newAdminServiceImp.getCommentToCensorship().size(), totalOnOnePage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		List<CommentDTOAdmin> commentDTO = newAdminServiceImp.getDataComments(paginateInfo.getStartPage(),
				totalOnOnePage);
		_mvShare.addObject("comments", commentDTO);
		return _mvShare;
	}

	// Phan trang
	@RequestMapping("/comments/pages/{page}")
	public ModelAndView checkComments(@PathVariable int page) {
		_mvShare.setViewName("admin/censorship/comments");
		PaginatesDTO paginateInfo = paginatesServiceImp
				.getInfoPaginate(newAdminServiceImp.getCommentToCensorship().size(), totalOnOnePage, page);
		_mvShare.addObject("paginateInfo", paginateInfo);

		List<CommentDTOAdmin> commentDTO = newAdminServiceImp.getDataComments(paginateInfo.getStartPage(),
				totalOnOnePage);
		_mvShare.addObject("comments", commentDTO);
		return _mvShare;
	}

	@RequestMapping("/delete-comment-new/{id}")
	public String deleteComment(@PathVariable int id) {
		commentLikeServiceImp.deleteComment(id);
		return "redirect://admin/new-admin/censorship-new/checkCommentAll/";
	}

	@RequestMapping("/accceptNew/{idNew}")
	public String accceptNew(@PathVariable int idNew) {
		newAdminServiceImp.updateNew(idNew, true);
		return "redirect://admin/new-admin/censorship-new/";
	}

	@RequestMapping("/dismissNew/{idNew}")
	public String dismissNew(@PathVariable int idNew) {
		newAdminServiceImp.updateNew(idNew, false);
		return "redirect://admin/new-admin/censorship-new/";
	}
}
