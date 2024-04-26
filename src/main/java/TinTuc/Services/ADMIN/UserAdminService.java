package TinTuc.Services.ADMIN;

import java.util.List;
import org.springframework.stereotype.Service;
import TinTuc.Entity.User;

@Service
public interface UserAdminService{
	public List<User> getAllUser();
	public User getUserByID(int id);
	public void insertUser(String name, String email, String password, String email_accuracy, String phone, int id_role);
	public void deleteUser(int id);
	public void updateUser(int id,String name, String email, String password, String email_accuracy, String phone, int id_role);
}
