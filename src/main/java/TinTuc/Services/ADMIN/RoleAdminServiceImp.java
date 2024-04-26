package TinTuc.Services.ADMIN;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.Entity.Role;
import TinTuc.Services.USER.BaseService;

@Service
public class RoleAdminServiceImp extends BaseService implements RoleAdminService{

	@Override
	public Role getRoleByID(int id) {
		return roleDAO.getRoleByID(id);
	}
	
	@Override
	public List<Role> getAllRole() {
		return roleDAO.getAllRole();
	}

	@Override
	public void insertRole(String roleName) {
		roleDAO.insertRole(roleName);
	}

	@Override
	public void updateRole(int id, String name) {
		roleDAO.updateRole(id, name);
	}

	@Override
	public void deleteRole(int id) {
		roleDAO.delete(id);
	}
}
