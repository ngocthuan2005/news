package TinTuc.Services.ADMIN;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.Entity.Role;

@Service
public interface RoleAdminService {
	public Role getRoleByID(int id);
	public void insertRole(String roleName);
	public void updateRole(int id, String name);
	public void deleteRole(int id);
	public List<Role> getAllRole();
}
