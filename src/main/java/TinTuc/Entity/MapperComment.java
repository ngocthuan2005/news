package TinTuc.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperComment implements RowMapper<Comment>{

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment comment = new Comment();
		comment.setId(rs.getInt(1));
		comment.setContent(rs.getString(2));
		comment.setComment_date(rs.getDate(3));
		comment.setId_user(rs.getInt(4));
		comment.setId_new(rs.getInt(5));
		comment.setStatus(rs.getBoolean(6));
		return comment;
	}

}
