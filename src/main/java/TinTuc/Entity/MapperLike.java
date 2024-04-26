package TinTuc.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperLike implements RowMapper<Like>{

	@Override
	public Like mapRow(ResultSet rs, int rowNum) throws SQLException {
		Like like = new Like();
		like.setId(rs.getInt(1));
		like.setId_user(rs.getInt(2));
		like.setId_new(rs.getInt(3));
		like.setLike(rs.getBoolean(4));
		return like;
	}
	
}
