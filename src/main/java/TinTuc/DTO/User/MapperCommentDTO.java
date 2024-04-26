package TinTuc.DTO.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCommentDTO implements RowMapper<CommentDTO>{

	@Override
	public CommentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setIdComment(rs.getInt(1));
		commentDTO.setIdUser(rs.getInt(2));
		commentDTO.setUserName(rs.getString(3));
		commentDTO.setCommentDate(rs.getDate(4));
		commentDTO.setContentComment(rs.getString(5));
		return commentDTO;
	}
}
