package TinTuc.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUser implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setEmail(rs.getString(3));
		user.setPassword(rs.getString(4));
		user.setId_role(rs.getInt(5));
		user.setMobile(rs.getString(6));
		user.setEmail_accuracy(rs.getString(7));
		return user;
	}

}
