package TinTuc.Services.USER;

import java.util.List;

import org.springframework.stereotype.Service;

import TinTuc.Entity.User;

@Service
public interface UserService{
	public List<User> logIn(String email, String password);
	public void signUp(String name, String email, String password);
}
