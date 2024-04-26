package TinTuc.DTO.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import TinTuc.DTO.User.NewDetailDTO;

public class MapperDetailAdmin implements RowMapper<NewDetailDTO>{
	@Override
	public NewDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NewDetailDTO newAdmin = new NewDetailDTO();
		newAdmin.setImage(rs.getString(1));
		newAdmin.setNewTitle(rs.getString(2));
		newAdmin.setAuthor(rs.getString(3));
		newAdmin.setPostingDate(rs.getDate(4));
		newAdmin.setContent(rs.getString(5));
		return newAdmin;
	}
}
