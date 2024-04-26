package TinTuc.Services.USER;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.Entity.User;

@Service
public class UserServiceImp extends BaseService implements UserService{

	@Override
	public List<User> logIn(String email, String password) {
		return userDAO.logIn(email, password);
	}

	@Override
	public void signUp(String name, String email, String password) {
		userDAO.signUp(name, email, password);
	}
}
