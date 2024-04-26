package TinTuc.Controller.ADMIN;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import TinTuc.Controller.USER.UserController;
import TinTuc.Entity.Role;
import TinTuc.Entity.User;

@Controller
@RequestMapping(value = "/admin/account")
public class AccountAdminController extends BaseAdminController{
	//Show danh sách tài khoản
	@RequestMapping("/showALL/{id_role}")
	public ModelAndView showAll(@PathVariable int id_role) {
		_mvShare.setViewName("admin/account/account");
		List<User> users = userAdminServiceImp.getAllUser();
		List<Role> roles = roleAdminServiceImp.getAllRole();
		_mvShare.addObject("roles", roles);
		_mvShare.addObject("users", users);
		return _mvShare;
	}
	
	//thêm account
	@RequestMapping(value = {"/insertAccount/"}, method = RequestMethod.GET)
	public ModelAndView insert() {
		_mvShare.setViewName("/admin/account/insertaccount");
		_mvShare.addObject("roles", roleAdminServiceImp.getAllRole());
		return _mvShare;
	}
	
	//Xem thông tin 1 tài khoản
	@RequestMapping(value = {"/showAccount/{id}"}, method = RequestMethod.GET)
	public ModelAndView showAccount(@PathVariable int id) {
		_mvShare.setViewName("admin/account/showaccount");
		User user = userAdminServiceImp.getUserByID(id); 
		_mvShare.addObject("userShow", user);
		_mvShare.addObject("nameRole",roleAdminServiceImp.getRoleByID(user.getId_role()).getName());		
		return _mvShare;
	}
	
	//Sửa tài khoản
	@RequestMapping(value = {"/updateAccount/{id}"}, method = RequestMethod.GET)
	public ModelAndView updateAccount(@PathVariable int id) {
		_mvShare.setViewName("admin/account/updateAccount");
		User user = userAdminServiceImp.getUserByID(id); 
		_mvShare.addObject("userUpdate", user);		
		_mvShare.addObject("roleAll", roleAdminServiceImp.getAllRole());
		return _mvShare;
	}
	
	@RequestMapping(value = {"/insert/"}, method = RequestMethod.POST)
	public String insertAccount(@RequestParam(name = "name", required = true) String name,@RequestParam(name = "phone", required = false) String phone, @RequestParam(name = "email", required = true) String email, @RequestParam(name = "password", required = true) String password, @RequestParam(name = "role_select", required = true) int role_select, @RequestParam(name = "email_accuracy", required = false) String email_accuracy) {
		String pass = encription(password);
		userAdminServiceImp.insertUser(name, email, pass, email_accuracy, phone, role_select);
		return "redirect:/admin/account/showALL/1";
	}
	
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

	
	@RequestMapping(value = "/updateAccount/", method = RequestMethod.POST)
	public String updateUser( @RequestParam(name = "id") int id,@RequestParam(name = "name") String name,@RequestParam(name = "role_select") int id_role,@RequestParam(name = "email") String email, @RequestParam(name = "password") String password,@RequestParam(name = "phone") String phone, @RequestParam(name = "email_accuracy") String email_accuracy ) {
		String pass = encription(password);
		userAdminServiceImp.updateUser(id, name, email, pass, email_accuracy, phone, id_role);
		return "redirect:/admin/1/";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		userAdminServiceImp.deleteUser(id);
		return "redirect:/admin/account/showALL/1/";
	}
}
