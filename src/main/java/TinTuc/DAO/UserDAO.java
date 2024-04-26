package TinTuc.DAO;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import TinTuc.Entity.MapperUser;
import TinTuc.Entity.User;

@Repository
public class UserDAO extends BaseDAO{
	
	@Override
	public void delete(int id) {
		jdbcTemplate.execute(delete(id, "user").toString());
	}
	
	public List<User> logIn(String email, String password) {
		StringBuffer sb = new StringBuffer();
		sb.append(
		"SELECT user.id, user.name, user.email, user.password, user.id_role, user.mobile, user.email_accuracy FROM user, role WHERE email = '")
		.append(email).append("' AND password = '")
		.append(password).append("' LIMIT 1");
		return jdbcTemplate.query(sb.toString(), new MapperUser());
	}
	
	public User getUserByID(int id) {
		return jdbcTemplate.query(getAll("user").append(" WHERE id = ").append(id).toString(), new MapperUser()).get(0);
	}
	
	public void signUp(String name, String email, String password) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO user (name, email, password) VALUES ('");
		sb.append(name);
		sb.append("', '");
		sb.append(email);
		sb.append("', '");
		sb.append(password);
		sb.append("');");
		jdbcTemplate.execute(sb.toString());
	}

	public void insertUser(String name, String email, String password, String email_accuracy, String phone, int id_role) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO user (name, email, password, email_accuracy, mobile, id_role) VALUES ('");
		sb.append(name);
		sb.append("', '");
		sb.append(email);
		sb.append("', '");
		sb.append(password);
		sb.append("', '");
		sb.append(email_accuracy);
		sb.append("");
		sb.append("', '");
		sb.append(phone);
		sb.append("");
		sb.append("', ");
		sb.append(id_role);
		sb.append(")");
		jdbcTemplate.execute(sb.toString());
	}
	
	public void updateUser(int id,String name, String email, String password, String email_accuracy, String phone, int id_role) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE user SET name = '");
		sb.append(name);
		sb.append("', email = '");
		sb.append(email);
		sb.append("', password ='");
		sb.append(password);
		sb.append("', id_role = ");
		sb.append(id_role);
		sb.append(", mobile = '");
		sb.append(phone);
		sb.append("', email_accuracy = '");
		sb.append(email_accuracy);
		sb.append("' WHERE id = ");
		sb.append(id);
		jdbcTemplate.execute(sb.toString());
	}
	
	public List<User> getAllUser(){
		return jdbcTemplate.query(getAll("user").toString(), new MapperUser());
	}
}
