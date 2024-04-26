package TinTuc.DTO.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperNewDTOAdmin implements RowMapper<NewDTOAdmin>{

	@Override
	public NewDTOAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
		NewDTOAdmin newDTOAdmin = new NewDTOAdmin();
		newDTOAdmin.setIdNew(rs.getInt(1));
		newDTOAdmin.setNewTitle(rs.getString(2));
		newDTOAdmin.setProperty(rs.getString(3));
		newDTOAdmin.setCategory(rs.getString(4));
		newDTOAdmin.setAuthor(rs.getString(5));
		newDTOAdmin.setStatus(rs.getBoolean(6));
		newDTOAdmin.setApprovalDate(rs.getDate(7));
		newDTOAdmin.setIdUser(rs.getInt(8));
		return newDTOAdmin;
	}

}
