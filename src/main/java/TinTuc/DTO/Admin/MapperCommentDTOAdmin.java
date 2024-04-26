package TinTuc.DTO.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public class MapperCommentDTOAdmin implements RowMapper<CommentDTOAdmin>{
	@Override
	@Nullable
	public CommentDTOAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentDTOAdmin commentDTOAdmin = new CommentDTOAdmin();
		commentDTOAdmin.setId(rs.getInt(1));
		commentDTOAdmin.setNewTitle(rs.getString(2));
		commentDTOAdmin.setUserComment(rs.getString(3));
		commentDTOAdmin.setContentComment(rs.getString(4));
		commentDTOAdmin.setCommentDate(rs.getDate(5));
		return commentDTOAdmin;
	}
}
