package TinTuc.Services.ADMIN;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.Entity.User;
import TinTuc.Services.USER.BaseService;

@Service
public class UserAdminServiceImp extends BaseService implements UserAdminService {

	@Override
	public List<User> getAllUser() {
		return userDAO.getAllUser();
	}

	public User getUserByID(int id) {
		return userDAO.getUserByID(id);
		
	}
	
	@Override
	public void insertUser(String name, String email, String password, String email_accuracy, String phone, int id_role) {
		userDAO.insertUser(name, email, password, email_accuracy, phone, id_role);
	}

	@Override
	public void deleteUser(int id) {
		userDAO.delete(id);
	}

	@Override
	public void updateUser(int id, String name, String email, String password, String email_accuracy, String phone, int id_role) {
		userDAO.updateUser(id, name, email, password, email_accuracy, phone, id_role);
	}
}
