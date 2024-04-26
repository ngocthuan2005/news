package TinTuc.Controller.USER;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.protobuf.Internal.ProtobufList;

import TinTuc.Entity.User;
import TinTuc.Services.USER.UserServiceImp;

@Controller
@RequestMapping("/login-signup")
public class UserController extends BaseController {
	ModelAndView mv = new ModelAndView();

	@Autowired
	UserServiceImp userServiceImp;

	@RequestMapping("/login/")
	public ModelAndView dangNhap() {
		mv.setViewName("/login-signup/login");
		return mv;
	}

	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public String dangNhap(HttpSession session, Model model, @RequestParam(name = "email", required = true) String email, @RequestParam(name = "password", required = true) String pass) {
		//String password = encription(pass);
		List<User> users = userServiceImp.logIn(email, pass);
		if (users.size() == 0) {
			model.addAttribute("login", "Đăng nhập thất bại");
			return "login-signup/login";
		}
		String url = "";
		User user = users.get(0);
		switch(user.getId_role()) {
		case 0:
			session.setAttribute("user", user);
			url = "redirect:/";
			break;
		case 1:
			//admin account
			session.setAttribute("admin", user);
			url = "redirect://admin/account/showALL/" + user.getId_role();
			break;
		case 2:
			//admin kiem duyet
			session.setAttribute("admin", user);
			url = "redirect:/admin/new-admin/censorship-new/";
			break;
		case 3:
			//admin new
			session.setAttribute("admin", user);
			url = "redirect:/admin/new-admin/write-new/" + user.getId_role() + "/";
			break;
		}
		return url;
	}

	/*
	 private String encription(String pass) {
	       StringBuffer sb = new StringBuffer();
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            md.update(pass.getBytes(StandardCharsets.UTF_8));
	            byte[] byteData = md.digest();
	            for (int i = 0; i < byteData.length; i++) {
	                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	            }
	        } catch (NoSuchAlgorithmException ex) {
	            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return sb.toString();
	    }
	    */

	
	@RequestMapping("/signup/")
	public ModelAndView dangKi() {
		mv.setViewName("/login-signup/signUp");
		return mv;
	}

	@RequestMapping(value = "/login-signup/signUp/", method = RequestMethod.POST)
	public String dangKy(@RequestParam(name = "name", required = true) String name, @RequestParam(name = "email", required = true) String email, @RequestParam(name = "password", required = true) String password) {
		//String pass = encription(password);
		userServiceImp.signUp(name, email, password);
		return "redirect:" + "/login-signup/login/";
	}

	@RequestMapping("/signOut/")
	public String dangXuat(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
}
