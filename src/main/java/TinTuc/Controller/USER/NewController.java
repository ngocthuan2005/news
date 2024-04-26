package TinTuc.Controller.USER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import TinTuc.DTO.User.NewDetailDTO;

@Controller
public class NewController extends BaseController{
	@RequestMapping("/tin-tuc/{newSlug}")
	public ModelAndView newDetail(@PathVariable String newSlug) {
		NewDetailDTO newDetailDTO = _newServiceImp.getNewDetailBySlug(newSlug);
		_mvShare.addObject("newDetail", newDetailDTO);
		_mvShare.addObject("newByAuthors", _newServiceImp.getNewByAuthor(newDetailDTO.getAuthorID()));
		_mvShare.addObject("newByProperties", _newServiceImp.getNewByProperty(newDetailDTO.getIdProperty()));
		_mvShare.addObject("comments", _commentLikeServiceImp.getDataComments(newSlug));
		_mvShare.setViewName("user/new-detail");
		return _mvShare;
	}
}
