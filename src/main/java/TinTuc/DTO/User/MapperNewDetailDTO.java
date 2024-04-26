package TinTuc.DTO.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperNewDetailDTO implements RowMapper<NewDetailDTO>{

	@Override
	public NewDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NewDetailDTO newDetailDTO = new NewDetailDTO();
		newDetailDTO.setAuthor(rs.getString(1));
		newDetailDTO.setNewTitle(rs.getString(2));
		newDetailDTO.setPropertyTitle(rs.getString(3));
		newDetailDTO.setApprovalDate(rs.getDate(4));
		newDetailDTO.setCategorySlug(rs.getString(5));
		newDetailDTO.setPropertySlug(rs.getString(6));
		newDetailDTO.setCategoryTitle(rs.getString(7));
		newDetailDTO.setView(rs.getInt(8));
		newDetailDTO.setContent(rs.getString(9));
		newDetailDTO.setLikes(rs.getInt(10));
		newDetailDTO.setCountComment(rs.getInt(11));
		newDetailDTO.setImage(rs.getString(12));
		newDetailDTO.setAuthorID(rs.getInt(13));
		newDetailDTO.setIdProperty(rs.getInt(14));
		newDetailDTO.setNewSlug(rs.getString(15));
		return newDetailDTO;
	}
	
}
