package TinTuc.Controller.ADMIN;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import TinTuc.Entity.Role;

@Controller
@RequestMapping("/admin/1/quan-ly-vai-tro")
public class RoleAdminController extends BaseAdminController {
	@RequestMapping("/")
	public ModelAndView indexRole() {
		_mvShare.setViewName("admin/account/role");
		List<Role> roles = roleAdminServiceImp.getAllRole();
		_mvShare.addObject("roles", roles);
		return _mvShare;
	}
	
	@RequestMapping(value = "/insertRole", method = RequestMethod.POST)
	public String insertRole(@RequestParam String role) {
		roleAdminServiceImp.insertRole(role);		
		return "redirect:/admin/1/quan-ly-vai-tro/";
	}
	
	@RequestMapping(value = "/insertRole")
	public ModelAndView insertRole() {
		_mvShare.setViewName("admin/account/insertrole");
		return _mvShare;
	}
	
	@RequestMapping(value = "/updateRole/{id}")
	public ModelAndView updateRole(@PathVariable int id) {
		_mvShare.setViewName("admin/account/updateRole");
		Role role = roleAdminServiceImp.getRoleByID(id);
		_mvShare.addObject("roleUpdate", role);
		return _mvShare;
	}
	
	@RequestMapping(value = "/updatRole", method = RequestMethod.POST)
	public String updateRole(@RequestParam int id,@RequestParam String roleUpdate) {
		roleAdminServiceImp.updateRole(id, roleUpdate);		
		return "redirect:/admin/1/quan-ly-vai-tro/";
	}
	
	@RequestMapping(value = "/deleteRole/{id}")
	public String deleteRole(@PathVariable int id) {
		roleAdminServiceImp.deleteRole(id);		
		return "redirect:/admin/1/quan-ly-vai-tro/";
	}
}
